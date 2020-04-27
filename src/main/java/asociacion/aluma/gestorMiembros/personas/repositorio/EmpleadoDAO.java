package asociacion.aluma.gestorMiembros.personas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asociacion.aluma.gestorMiembros.personas.Empleado;

@Repository
public interface EmpleadoDAO extends JpaRepository<Empleado, String> {

}
