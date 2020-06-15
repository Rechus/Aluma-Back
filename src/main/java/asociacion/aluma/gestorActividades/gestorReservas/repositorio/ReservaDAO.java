package asociacion.aluma.gestorActividades.gestorReservas.repositorio;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


import asociacion.aluma.gestorActividades.gestorReservas.Reserva;

@CrossOrigin(origins = {"http://localhost:4200" , "https://rechus.github.io"})
@RepositoryRestResource(path = "reservas", itemResourceRel = "reserva", collectionResourceRel = "reservas")
public interface ReservaDAO extends JpaRepository<Reserva, Integer>, ReservaDAOCustom<Reserva> {

	@RestResource(path="fecha-intervalo")
	List<Reserva> findByFechaBetween(Instant comienzo, Instant fin);
}
