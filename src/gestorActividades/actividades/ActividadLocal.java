package gestorActividades.actividades;

import java.util.Date;

import gestorActividades.gestorReservas.Reserva;
import gestorMiembros.personas.Persona;

public class ActividadLocal extends ActividadImp {

	public ActividadLocal(String nombre, Date fecha, int numeroPlazas, double[] precio, int reservaPlazasEmpleados) {
		super(nombre, fecha, numeroPlazas, precio, reservaPlazasEmpleados);
	}

	@Override
	public void reservar(Persona persona) {
		if (this.getListaParticipantes().containsValue(persona)) {
			System.out.println ("Ya existe una reserva para esa persona");
		}else {
			int valorUltimaReserva = this.getListaReservas().lastKey();
			if ( valorUltimaReserva < this.getNumeroPlazas()) {
				this.getListaReservas().put( valorUltimaReserva + 1 , new Reserva());
			}
		}
		
	}

}
