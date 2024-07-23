package mx.gob.tecdmx.directorio_ciudadano.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.directorio_ciudadano.entity.EntidadFederativa;

@Repository
public interface EntidadFederativaRepository extends CrudRepository<EntidadFederativa, Integer> {
		
	
}
