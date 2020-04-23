package gestorActividades.actividades;

import java.time.Instant;

import gestorActividades.gestorReservas.Reserva;
import gestorMiembros.personas.Empleado;
import gestorMiembros.personas.Persona;

public class ActividadLocal extends ActividadImp {

	public ActividadLocal(String nombre, Instant fecha, int numeroPlazas, double precio, int reservaPlazasEmpleados) {
		super(nombre, fecha, numeroPlazas, precio, reservaPlazasEmpleados);
	}

	@Override
	public boolean reservar(Persona persona) {
		if(comprobarReserva(persona)) {
			return false;
	}else {
		
	}

		} else {
			Integer valorUltimaReserva;
			// Esto debe hacerte saltar la alarma de un diseno pobre
			if (!(persona instanceof Empleado)) {

				/*
				 * Buscamos la clave mayor que sea menor del número de plazas, ya que estas ya
				 * están descontandas las plazas reservadas para los empleados, getnumeroplazas
				 * = numero de plazas - numero de plazas reservadas a empleados
				 */
				// Otro metodo para encontrar el numero
				// Esto me hace pensar que confias en tu idea de los enteros para mas cosas todavia
				// Ya te digo que hay que buscar otra solucion
				// Algo tan simple como recorrer las reservas y encontrar la mayor
				// getListaReservas().values().stream().mapToInt(Reserva::getNumeroReserva).min();
				// pero ahorrandore el .values() si no es un mapa y es simplemente una coleccion
				valorUltimaReserva = this.getListaReservas().floorKey(this.getNumeroPlazas());
				// Cambia null por un Optional empty para saberlo
				// Si nos devuelve null significa que no hay ninguna reserva aún
				if (valorUltimaReserva == null) {
					valorUltimaReserva = 0;
				}
				if (valorUltimaReserva < this.getNumeroPlazas()) {
					this.getListaReservas().put(valorUltimaReserva + 1, new Reserva(persona, this));
					// añadimos el numero de reserva al atributo de la reserva del mismo nombre
					this.getListaReservas().get(valorUltimaReserva + 1).setNumeroReserva(valorUltimaReserva + 1);
				} else {
					// Otro metodo para saber si no quedan plazas que deberias usarlo antes
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
					// Eres un maestro de la cuenta la vieja macho. Vas a sufrir por este camino
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
