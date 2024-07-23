package mx.gob.tecdmx.directorio_ciudadano.api.ciudadano;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.gob.tecdmx.directorio_ciudadano.entity.Ciudadano;
import mx.gob.tecdmx.directorio_ciudadano.entity.EntidadFederativa;
import mx.gob.tecdmx.directorio_ciudadano.entity.TipoSolicitud;
import mx.gob.tecdmx.directorio_ciudadano.repository.CiudadanoRepository;
import mx.gob.tecdmx.directorio_ciudadano.repository.EntidadFederativaRepository;
import mx.gob.tecdmx.directorio_ciudadano.repository.TipoSolicitudRepository;
import mx.gob.tecdmx.directorio_ciudadano.utils.DTOResponse;

@Service
public class CiudadanoService {
	
	@Autowired
	CiudadanoRepository ciudadanoRepository;
	
	@Autowired
	EntidadFederativaRepository entidadFederativaRepository;
	
	@Autowired
	TipoSolicitudRepository tipoSolicitudRepository;
	
	public DTOResponse registerCiudadano(CiudadanoPayload payload, DTOResponse response) {
		
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
		
		ciudadanoRepository.save(ciudadano);
		
		return response;
	}

}
