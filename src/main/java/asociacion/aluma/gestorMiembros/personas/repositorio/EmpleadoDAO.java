package asociacion.aluma.gestorMiembros.personas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import asociacion.aluma.gestorMiembros.personas.Empleado;

@RepositoryRestResource(path = "members", itemResourceRel = "member", collectionResourceRel = "members")
public interface EmpleadoDAO extends JpaRepository<Empleado, String> {

}
