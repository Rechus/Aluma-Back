package asociacion.aluma.gestorActividades.actividades.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asociacion.aluma.gestorActividades.actividades.ActividadImp;

@Repository
public interface ActividadImpDAO extends JpaRepository<ActividadImp, String> {

}
