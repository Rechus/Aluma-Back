package asociacion.aluma.rest;

import java.util.List;

import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import asociacion.aluma.gestorActividades.gestorReservas.Reserva;
import asociacion.aluma.gestorActividades.gestorReservas.repositorio.ReservaDAO;

@RepositoryRestController
public class ReservaController {

	private ReservaDAO reservaDAO;

	ReservaController(ReservaDAO reservaDAO) {
		this.reservaDAO = reservaDAO;
	}

	@GetMapping("/reservas/search/por-persona-dni")
	@ResponseBody
	public CollectionModel<PersistentEntityResource> getReservasPorPersonaDni(@RequestParam String dni,
			PersistentEntityResourceAssembler assembler) {
		List<Reserva> reservas = reservaDAO.getReservasPorPersona(dni);

		return assembler.toCollectionModel(reservas);
	}

}
