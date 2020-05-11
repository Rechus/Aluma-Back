package asociacion.aluma.gestorMiembros.personas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import asociacion.aluma.gestorMiembros.personas.Persona;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(path = "people", itemResourceRel = "person", collectionResourceRel = "people")
public interface PersonaDAO extends JpaRepository<Persona, String> {

	

}
