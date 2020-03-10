package gestorActividades.actividades;

import java.time.Instant;

import gestorActividades.gestorReservas.Reserva;
import gestorMiembros.personas.Empleado;
import gestorMiembros.personas.Persona;

public class ActividadLocal extends ActividadImp {

	public ActividadLocal(String nombre, Instant fecha, int numeroPlazas, double[] precio, int reservaPlazasEmpleados) {
		super(nombre, fecha, numeroPlazas, precio, reservaPlazasEmpleados);
	}

	@Override
	public void reservar(Persona persona) {
		boolean existeReserva = false;
		/* Comprobamos que no exista una reserva para esa persona */
		for (Reserva reserva : this.getListaReservas().values()) {
			if (reserva.getPersona().equals(persona)) {
				existeReserva = true;
				break;
			}
			existeReserva = false;
		}
		if (existeReserva) {
			System.out.println("Ya existe una reserva para esa persona");

		} else {
			Integer valorUltimaReserva;
			if (!(persona instanceof Empleado)) {

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
					// añadimos el numero de reserva al atributo de la reserva del mismo nombre
					this.getListaReservas().get(valorUltimaReserva + 1).setNumeroReserva(valorUltimaReserva + 1);
				} else {
					System.out.println("Limite de reservas alcanzado");
				}
			} else {
				/*
				 * Para los empleados comprabamos que no sea la primera reserva de empleados
				 * empezando por el límite de getnumero de plazas
				 */
				if (!this.getListaReservas().containsKey(this.getNumeroPlazas() + 1)) {
					this.getListaReservas().put(this.getNumeroPlazas() + 1, new Reserva(persona, this));
					this.getListaReservas().get(this.getNumeroPlazas() + 1)
							.setNumeroReserva(this.getNumeroPlazas() + 1);
				} else {
					/*
					 * En caso de que haya una reserva de empleado hecha, solo tenemos que coger la
					 * clave más alta de nuestro mapa y sumarle uno a la clave
					 */
					valorUltimaReserva = this.getListaReservas().lastKey();
					if (valorUltimaReserva < (this.getNumeroPlazas() + getReservaPlazasEmpleados())) {
						this.getListaReservas().put(valorUltimaReserva + 1, new Reserva(persona, this));
						this.getListaReservas().get(valorUltimaReserva + 1).setNumeroReserva(valorUltimaReserva + 1);
					} else {
						System.out.println("Limite de reservas alcanzado para empleados");
					}
				}
			}
		}
	}

}
