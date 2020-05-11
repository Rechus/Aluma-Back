package asociacion.aluma.gestorActividades.actividades.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import asociacion.aluma.gestorActividades.actividades.ActividadExterna;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(path = "outer-activities", itemResourceRel = "outer-activity", collectionResourceRel = "outer-activities")
public interface ActividadExternaDAO extends JpaRepository<ActividadExterna, String> {

}
