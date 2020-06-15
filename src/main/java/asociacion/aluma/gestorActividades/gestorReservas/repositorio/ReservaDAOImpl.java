package asociacion.aluma.gestorActividades.gestorReservas.repositorio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import asociacion.aluma.App;
import asociacion.aluma.gestorActividades.gestorReservas.Reserva;
import asociacion.aluma.gestorMiembros.personas.Persona;
import asociacion.aluma.gestorMiembros.personas.repositorio.PersonaDAO;

@Transactional(readOnly = true)
public class ReservaDAOImpl implements ReservaDAOCustom<Reserva> {
	
	private static final Logger log = LoggerFactory.getLogger(App.class);

	@Autowired
	PersonaDAO personaDAO;

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<Reserva> getReservasPorPersona(String dni) {
		List<Persona> personas = personaDAO.findByDniIgnoreCaseContaining(dni);
		Set<Reserva> reservas = new HashSet<Reserva>();
		Query query = entityManager.createNativeQuery("SELECT r.* FROM reserva as r " + "WHERE r.per = ?1",
				Reserva.class);
		personas.forEach(r -> {
			query.setParameter(1, r.getDni());
			reservas.addAll(query.getResultList());
			log.trace(reservas.toString());
		});

		return new ArrayList<Reserva>(reservas);

	}

	
}
