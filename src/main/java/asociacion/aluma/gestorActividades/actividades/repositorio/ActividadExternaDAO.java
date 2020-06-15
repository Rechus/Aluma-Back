package asociacion.aluma.gestorActividades.actividades.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import asociacion.aluma.gestorActividades.actividades.ActividadExterna;

@RepositoryRestResource(path = "externas", itemResourceRel = "externa", collectionResourceRel = "externas")
public interface ActividadExternaDAO extends JpaRepository<ActividadExterna, String> {

	@RestResource(path = "destino")
	List<ActividadExterna> findByDestinoIgnoreCaseContaining(@Param("destino") String destino);
}
