package asociacion.aluma.gestorMiembros.personas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import asociacion.aluma.gestorMiembros.personas.Socio;

@RepositoryRestResource(path = "socios", itemResourceRel = "socio", collectionResourceRel = "socios")
public interface SocioDAO extends JpaRepository<Socio, String> {

}
