package mx.gob.tecdmx.directorio_ciudadano.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.directorio_ciudadano.entity.Ciudadano;


@Repository
public interface CiudadanoRepository extends CrudRepository<Ciudadano, Integer> {
	
	Optional<Ciudadano> findByEmail(String email);
	
	
}