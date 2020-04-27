package asociacion.aluma.gestorActividades.gestorReservas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import asociacion.aluma.gestorActividades.gestorReservas.Reserva;

@Repository
public interface ReservaDAO extends JpaRepository<Reserva , Integer>{

}
