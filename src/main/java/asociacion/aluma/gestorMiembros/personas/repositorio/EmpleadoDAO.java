package asociacion.aluma.gestorMiembros.personas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import asociacion.aluma.gestorMiembros.personas.Empleado;

@CrossOrigin(origins = {"http://localhost:4200" , "https://rechus.github.io"})
@RepositoryRestResource(path = "miembros", itemResourceRel = "miembro", collectionResourceRel = "miembros")
public interface EmpleadoDAO extends JpaRepository<Empleado, String> {

}
