package asociacion.aluma.gestorActividades.actividades.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import asociacion.aluma.gestorActividades.actividades.ActividadLocal;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(path = "local-activities", itemResourceRel = "local-activity", collectionResourceRel = "local-activities")
public interface ActividadLocalDAO extends JpaRepository<ActividadLocal, String> {

}
