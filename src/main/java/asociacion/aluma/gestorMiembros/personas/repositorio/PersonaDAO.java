package asociacion.aluma.gestorMiembros.personas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import asociacion.aluma.gestorMiembros.personas.Persona;

//@Repository
@RepositoryRestResource(path="people", itemResourceRel = "person" , collectionResourceRel = "people")
public interface PersonaDAO extends JpaRepository<Persona, String>{

}
