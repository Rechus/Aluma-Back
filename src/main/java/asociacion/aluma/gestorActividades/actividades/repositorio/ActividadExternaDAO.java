package asociacion.aluma.gestorActividades.actividades.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import asociacion.aluma.gestorActividades.actividades.ActividadExterna;

@RepositoryRestResource(path="outer-activities", itemResourceRel = "outer-activity" , collectionResourceRel = "outer-activities")
public interface ActividadExternaDAO extends JpaRepository<ActividadExterna, String>{

}
