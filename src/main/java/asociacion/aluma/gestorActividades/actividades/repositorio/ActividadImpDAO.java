package asociacion.aluma.gestorActividades.actividades.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import asociacion.aluma.gestorActividades.actividades.ActividadImp;


@RepositoryRestResource(path = "activities", itemResourceRel = "activity", collectionResourceRel = "activities")
public interface ActividadImpDAO extends JpaRepository<ActividadImp, String> {

}
