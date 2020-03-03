package gestorActividades.actividades;

import java.time.Instant;

import gestorActividades.gestorReservas.Reserva;
import gestorMiembros.personas.Persona;


public class ActividadLocal extends ActividadImp {

	public ActividadLocal(String nombre, Instant fecha, int numeroPlazas, double[] precio, int reservaPlazasEmpleados) {
		super(nombre, fecha, numeroPlazas, precio, reservaPlazasEmpleados);
	}

	@Override
	public void reservar(Persona persona) {
		/* Comprobamos que no exista una reserva para esa persona */
		if (this.getListaParticipantes().containsValue(persona)) {
			System.out.println("Ya existe una reserva para esa persona");
		} else {
			Integer valorUltimaReserva;
			if (!persona.getClass().getName().equals("Empleado")) {

				/*
				 * Buscamos la clave mayor que sea menor del número de plazas, ya que estas ya
				 * están descontandas las plazas reservadas para los empleados, getnumeroplazas
				 * = numero de plazas - numero de plazas reservadas a empleados
				 */
				valorUltimaReserva = this.getListaReservas().floorKey(this.getNumeroPlazas());
				// Si nos devuelve null significa que no hay ninguna reserva aún
				if (valorUltimaReserva == null) {
					valorUltimaReserva = 0;
				}
				if (valorUltimaReserva < this.getNumeroPlazas()) {
					this.getListaReservas().put(valorUltimaReserva + 1, new Reserva(persona, this));
				}
				System.out.println("Limite de reservas alcanzado");
			} else {
				/* Para los empleados comprabamos que no sea la primera reserva de empleados
				 * empezando por el límite de getnumero de plazas */
				if (!this.getListaReservas().containsKey(this.getNumeroPlazas() + 1)) {
					this.getListaReservas().put(this.getNumeroPlazas() + 1, new Reserva(persona, this));
				}else { 
					/* En caso de que haya una reserva de empleado hecha, solo tenemos que coger la
					 * clave más alta de nuestro mapa y  sumarle uno a la clave */ 
				valorUltimaReserva = this.getListaReservas().lastKey();
				this.getListaReservas().put(valorUltimaReserva + 1, new Reserva(persona, this));
				}
			}
		}
	}
}
