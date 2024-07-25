package mx.gob.tecdmx.directorio_ciudadano.api.ciudadano;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import mx.gob.tecdmx.directorio_ciudadano.entity.Ciudadano;
import mx.gob.tecdmx.directorio_ciudadano.entity.EntidadFederativa;
import mx.gob.tecdmx.directorio_ciudadano.entity.TipoSolicitud;
import mx.gob.tecdmx.directorio_ciudadano.repository.CiudadanoRepository;
import mx.gob.tecdmx.directorio_ciudadano.repository.EntidadFederativaRepository;
import mx.gob.tecdmx.directorio_ciudadano.repository.TipoSolicitudRepository;
import mx.gob.tecdmx.directorio_ciudadano.utils.DTOResponse;
import mx.gob.tecdmx.directorio_ciudadano.utils.MetodosUtils;
import mx.gob.tecdmx.directorio_ciudadano.utils.RestClient;

@Service
public class CiudadanoService {
	
	@Autowired
	CiudadanoRepository ciudadanoRepository;
	
	@Autowired
	EntidadFederativaRepository entidadFederativaRepository;
	
	@Autowired
	TipoSolicitudRepository tipoSolicitudRepository;
	
	@Value("${app.url.user-register}")
	private String userRegister;
	
	public DTOResponse registrarCiudadano(CiudadanoPayload payload, DTOResponse response) {
		
		Optional<Ciudadano> ciudadanoExist = ciudadanoRepository.findByEmail(payload.getEmail());
		if(ciudadanoExist.isPresent()) {
			response.setMessage("El ciudadano con el email "+payload.getEmail()+" ya existe");
			return response;
		}
		
		Ciudadano ciudadano = new Ciudadano();
		ciudadano.setNombre(payload.getNombre());
		ciudadano.setApellido1(payload.getApellido1());
		ciudadano.setApellido2(payload.getApellido2());
		ciudadano.setFhNac(payload.getFhNac());
		ciudadano.setSexo(payload.getSexo());
		ciudadano.setTelefono(payload.getTelefono());
		ciudadano.setCalleNumero(payload.getCalleNumero());
		ciudadano.setColonia(payload.getColonia());
		ciudadano.setCp(payload.getCp());
		
		Optional<EntidadFederativa> entidadf = entidadFederativaRepository.findById(payload.getEntidadFederativa());
		if(!entidadf.isPresent()) {
			response.setMessage("La entidad federativa no existe");
			return response;
		}
		
		ciudadano.setEntidadFederativa(entidadf.get());
		ciudadano.setCiudad(payload.getCiudad());
		ciudadano.setEmail(payload.getEmail());
		
		Optional<TipoSolicitud> tipoSolicitud = tipoSolicitudRepository.findById(payload.getTipoSolicitud());
		if(!tipoSolicitud.isPresent()) {
			response.setMessage("El tipo de solicitud no existe");
			return response;
		}
		
		ciudadano.setTipoSolicitud(tipoSolicitud.get());
		
		
		ciudadano.setInstitucion(payload.getInstitucion());
		
		ciudadano.setAceptacionTerminosUso(payload.isAceptacionTerminosUso());
		
		Ciudadano ciudadanoStored = ciudadanoRepository.save(ciudadano);
		
		UsuarioPayload usuario = new UsuarioPayload();
		MetodosUtils utils = new MetodosUtils();
		
		String nombreUsuario = utils.createRandomUserName(ciudadano.getNombre(),ciudadano.getApellido1());
				
		List<String> codigoRol = new ArrayList<String>();
		codigoRol.add("CIUDADANO_JEL");
		
		usuario.setUsuario(nombreUsuario);
		usuario.setEmail(ciudadano.getEmail());
		usuario.setContrasenia(nombreUsuario);
		usuario.setStatusCuenta(5);//Activa
		usuario.setCodigoRol(codigoRol);
		usuario.setCodigoSistema("GJE");
		
		RestClient restClient = new RestClient();
		Gson gson = new Gson();
		String json = gson.toJson(usuario);
		String respPost = restClient.sendPostRequest(userRegister, null, json);
		DTOResponse responseUsuario = gson.fromJson(respPost, DTOResponse.class);
		
		payload.setIdUsuario(ciudadanoStored.getId());
		
		Map<String, Object> map = new HashMap<>();

        // Agregar elementos al mapa
        map.put("ciudadano", payload);
        map.put("usuario", responseUsuario.getData());   
        response.setData(map);

		return response;
	}

}
