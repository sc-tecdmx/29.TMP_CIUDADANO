package mx.gob.tecdmx.directorio_ciudadano.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.directorio_ciudadano.entity.Ciudadano;


@Repository
public interface CiudadanoRepository extends CrudRepository<Ciudadano, Integer> {
	
	
}