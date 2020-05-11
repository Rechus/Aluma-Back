package asociacion.aluma.gestorActividades.actividades.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import asociacion.aluma.gestorActividades.actividades.ActividadImp;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(path = "actividades", itemResourceRel = "actividad", collectionResourceRel = "actividades")
public interface ActividadImpDAO extends JpaRepository<ActividadImp, String> {

}
