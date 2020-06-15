package asociacion.aluma.gestorActividades.gestorReservas.repositorio;

import java.util.List;

import asociacion.aluma.gestorActividades.gestorReservas.Reserva;

public interface ReservaDAOCustom<T extends Reserva> {

	List<T> getReservasPorPersona(String dni);
	
}
