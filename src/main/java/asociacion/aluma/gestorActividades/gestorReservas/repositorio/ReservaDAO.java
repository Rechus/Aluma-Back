package asociacion.aluma.gestorActividades.gestorReservas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import asociacion.aluma.gestorActividades.gestorReservas.Reserva;

@CrossOrigin(origins = "http://localhost:4200")
@RepositoryRestResource(path = "bookings", itemResourceRel = "booking", collectionResourceRel = "bookings")
public interface ReservaDAO extends JpaRepository<Reserva, Integer> {

}
