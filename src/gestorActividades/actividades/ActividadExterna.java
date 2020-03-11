package gestorActividades.actividades;

import java.time.Instant;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

import gestorActividades.gestorReservas.Reserva;
import gestorMiembros.personas.Empleado;
import gestorMiembros.personas.Persona;

public class ActividadExterna extends ActividadImp {

	private String destino;
	private Transporte tipoTransporte;

	public enum Transporte {
		autobus, tren, avion
	}

	public String getDestino() {
		return destino;
	}

	public Transporte getTipoTransporte() {
		return tipoTransporte;
	}

	public ActividadExterna(String nombre, Instant fecha, int numeroPlazas, double[] precio, int reservaPlazasEmpleados,
			String destino, ActividadExterna.Transporte transporte) {
		super(nombre, fecha, numeroPlazas, precio, reservaPlazasEmpleados);
		this.destino = destino;
		this.tipoTransporte = transporte;
	}

	public int elegirPlaza() {
		int plazaDeseada = -1;
		/* Miramos que no esté llena ya la lista antes de elegir */

		try {
			if (this.getListaReservas().size() == this.getNumeroPlazas() + this.getReservaPlazasEmpleados()) {
				plazaDeseada = -2;

			} else {

				/*
				 * utilizo un número entero aleatorio para simular la elección de plaza por
				 * parte del usuario, está función se implementará posteriormente
				 */

				plazaDeseada = ThreadLocalRandom.current().nextInt(this.getReservaPlazasEmpleados(),
						this.getNumeroPlazas() + this.getReservaPlazasEmpleados() + 1);
				System.out.println("plaza número: " + plazaDeseada);

				/* Buscamos si exise una reserva con numero de la plaza deseada */
				if (this.getListaReservas().containsKey(plazaDeseada)) {
					System.out.println("Plaza ocupada, por favor, ingrese una plaza libre");
					plazaDeseada = -1;
				}
			}
		} catch (NoSuchElementException e) {

			/*
			 * Si ocurre la excepción es porque es el primero en reservar por lo tanto no
			 * es necesario comprobar que la plaza esté ocupada
			 */
			plazaDeseada = ThreadLocalRandom.current().nextInt(this.getReservaPlazasEmpleados(),
					this.getNumeroPlazas() + this.getReservaPlazasEmpleados() + 1);

		}

		return plazaDeseada;
	}

	@Override
	public void reservar(Persona persona) {
		boolean existeReserva = false;
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

			/*
			 * Él único transporte que se puede seleccionar plaza es el autobus, el resto de
			 * transportes será la agencia de viajes quién asigne las plazas en fución del n
			 * de reserva, la implentación del resto de transporte será exactamente igual
			 * que en la actividad local
			 */

			if (this.getTipoTransporte().equals(ActividadExterna.Transporte.autobus)) {
				if (!(persona instanceof Empleado)) {

					/* Solitamos la plaza al usuario */
					int plazaDeseada = -1;
						while (plazaDeseada == -1) {
						System.out.print(persona.getNombre() + " elige ");
						plazaDeseada = elegirPlaza();
					}

					if (plazaDeseada == -2) {
						System.out.println("No existen plazas libres en esta actividad");
					} else {
						this.getListaReservas().put(plazaDeseada, new Reserva(persona, this));
						this.getListaReservas().get(plazaDeseada).setNumeroReserva(plazaDeseada);
					}
				} else {
					/*
					 * No importa el orden para los empleados, siempre rellenarán las primeras
					 * plazas comprobamos que no estén ya llenas
					 */
					
					
						
					if (this.getListaReservas().containsKey(this.getReservaPlazasEmpleados())) {
						System.out.println("No existen plazas libres para empleados");
					} else {

						/*
						 * Buscamos la clave más baja de los empleados, y que reserve la siguiente al más bajo
						 */
						try {
							
						Integer claveMasBajaEmpleados = this.getListaReservas().floorKey(this.getReservaPlazasEmpleados());
								
						
							this.getListaReservas().put(claveMasBajaEmpleados + 1, new Reserva(persona, this));
							this.getListaReservas().get(claveMasBajaEmpleados + 1)
									.setNumeroReserva(claveMasBajaEmpleados + 1);
					} catch (NullPointerException e) {
					/* Si no existe ningún elemento entonces será el primero */
					this.getListaReservas().put(1, new Reserva(persona, this));
					this.getListaReservas().get(1).setNumeroReserva(1);
					}
				}
			}

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
							this.getListaReservas().get(valorUltimaReserva + 1)
									.setNumeroReserva(valorUltimaReserva + 1);
						} else {
							System.out.println("Limite de reservas alcanzado para empleados");
						}
					}
				}
			}
		}

	}

}
