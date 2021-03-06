package asociacion.aluma.gestorMiembros.personas.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import asociacion.aluma.gestorMiembros.personas.Persona;

@RepositoryRestResource(path = "personas", itemResourceRel = "persona", collectionResourceRel = "personas")
public interface PersonaDAO extends JpaRepository<Persona, String> {

	@RestResource(path = "apellido")
	List<Persona> findByPrimerApelloIgnoreCaseContaining(@Param("apellido") String apellido);

	@RestResource(path = "dni")
	List<Persona> findByDniIgnoreCaseContaining(@Param("dni") String dni);

}
