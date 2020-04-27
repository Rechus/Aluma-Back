package asociacion.aluma.gestorActividades.actividades.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asociacion.aluma.gestorActividades.actividades.ActividadLocal;

@Repository
public interface ActividadLocalDAO extends JpaRepository<ActividadLocal, String> {

}
