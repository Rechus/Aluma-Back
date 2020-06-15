package asociacion.aluma.gestorMiembros.personas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import asociacion.aluma.gestorMiembros.personas.Acompanante;

@RepositoryRestResource(path = "acompanantes", itemResourceRel = "acompanante", collectionResourceRel = "acompanantes")
public interface AcompananteDAO extends JpaRepository<Acompanante, String> {

}
