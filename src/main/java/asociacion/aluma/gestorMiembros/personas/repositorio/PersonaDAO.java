package asociacion.aluma.gestorMiembros.personas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import asociacion.aluma.gestorMiembros.personas.Persona;

@RepositoryRestResource(path = "people", itemResourceRel = "person", collectionResourceRel = "people")
public interface PersonaDAO extends JpaRepository<Persona, String> {

}
