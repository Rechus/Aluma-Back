package asociacion.aluma.gestorActividades.gestorReservas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import asociacion.aluma.gestorActividades.gestorReservas.Reserva;

//@Repository
@RepositoryRestResource(path="bookings", itemResourceRel = "booking" , collectionResourceRel = "bookings")
public interface ReservaDAO extends JpaRepository<Reserva , Integer>{

}
