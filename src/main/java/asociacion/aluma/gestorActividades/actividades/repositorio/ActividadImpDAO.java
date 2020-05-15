package asociacion.aluma.gestorActividades.actividades.repositorio;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


import asociacion.aluma.gestorActividades.actividades.ActividadImp;


@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(path = "actividades", itemResourceRel = "actividad", collectionResourceRel = "actividades")
public interface ActividadImpDAO extends JpaRepository<ActividadImp, String> {

	@RestResource(path="nombre")
	List<ActividadImp> findByNombreIgnoreCaseContaining(@Param("nombre") String nombre);
	
	@RestResource(path="fecha-intervalo")
	List<ActividadImp> findByFechaBetween(Instant comienzo, Instant fin);
	
	@RestResource(path="fecha-comienzo")
	List<ActividadImp> findByFechaAfter(@Param("comienzo")Instant comienzo);
	
	@RestResource(path="id")
	List<ActividadImp> findByid(@Param("id")String id);
}  
