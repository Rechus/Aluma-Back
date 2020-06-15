package asociacion.aluma.gestorActividades.actividades.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import asociacion.aluma.gestorActividades.actividades.ActividadLocal;

@RepositoryRestResource(path = "locales", itemResourceRel = "local", collectionResourceRel = "locales")
public interface ActividadLocalDAO extends JpaRepository<ActividadLocal, String> {

}
