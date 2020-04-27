package asociacion.aluma.gestorMiembros.personas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asociacion.aluma.gestorMiembros.personas.Socio;

@Repository
public interface SocioDAO extends JpaRepository<Socio , String>{

}
