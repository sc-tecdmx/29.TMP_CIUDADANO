package mx.gob.tecdmx.directorio_ciudadano.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.gob.tecdmx.directorio_ciudadano.entity.TipoSolicitud;


@Repository
public interface TipoSolicitudRepository extends CrudRepository<TipoSolicitud, Integer> {
	
	
}