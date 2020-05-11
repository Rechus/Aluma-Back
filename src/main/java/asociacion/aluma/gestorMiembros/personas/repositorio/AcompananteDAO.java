package asociacion.aluma.gestorMiembros.personas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import asociacion.aluma.gestorMiembros.personas.Acompanante;


@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(path = "acompanantes", itemResourceRel = "acompanante", collectionResourceRel = "acompanantes")
public interface AcompananteDAO extends JpaRepository<Acompanante, String> {

}
