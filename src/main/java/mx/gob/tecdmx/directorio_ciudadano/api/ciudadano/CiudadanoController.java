package mx.gob.tecdmx.directorio_ciudadano.api.ciudadano;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mx.gob.tecdmx.directorio_ciudadano.utils.DTOResponse;
import mx.gob.tecdmx.directorio_ciudadano.utils.MetodosUtils;


@CrossOrigin
@RequestMapping("/api/v1/ciudadano")
@RestController
public class CiudadanoController {

	@Autowired
	CiudadanoService ciudadanoService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/{idCiudadano}")
	public String getCiudadano() {
		
		return null;
	}
	
	@CrossOrigin()
	@RequestMapping(method = RequestMethod.POST, path = "/", produces = "application/json")
	@ResponseBody
	public ResponseEntity<String> createUAdscripcionAreas(@RequestBody CiudadanoPayload payload) {
		MetodosUtils utils = new MetodosUtils();
		DTOResponse response = new DTOResponse();
		ciudadanoService.registerCiudadano(payload, response);
		return ResponseEntity.ok().header(null).body(utils.objectToJson(response));
	}

}
