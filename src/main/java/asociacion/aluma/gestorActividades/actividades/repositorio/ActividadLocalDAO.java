package asociacion.aluma.gestorActividades.actividades.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import asociacion.aluma.gestorActividades.actividades.ActividadLocal;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(path = "locales", itemResourceRel = "local", collectionResourceRel = "locales")
public interface ActividadLocalDAO extends JpaRepository<ActividadLocal, String> {

}
