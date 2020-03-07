package gestorActividades.actividades;

import java.time.Instant;

import java.util.Scanner;

import gestorActividades.gestorReservas.Reserva;
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
			int numeroPlaza, String destino) {
		super(nombre, fecha, numeroPlazas, precio, reservaPlazasEmpleados);
		this.destino = destino;
	}

	public int elegirPlaza() {
		/* para el primer prototipo voy a utilizar un scanner para simular*
		 * la elección de plaza por parte del usuario*/
		Scanner scan = new Scanner(System.in);
		int plazaDeseada = scan.nextInt();
		if (plazaDeseada > this.getNumeroPlazas() && plazaDeseada > 0) {
			System.out.println("Por favor elija una plaza válida");
			elegirPlaza();
		}
		/* Buscamos si exise una reserva con numero de la plaza deseada */
		if (this.getListaReservas().containsKey(plazaDeseada)) {	 
			System.out.println("Plaza ocupada, por favor, ingrese una plaza libre");
			elegirPlaza();
		}
			return plazaDeseada;
	}

	@Override
	public void reservar(Persona persona) {

		if (this.getListaParticipantes().containsValue(persona)) {
			System.out.println("Ya existe una reserva para esa persona");
		} else {

			/*
			 * Él único transporte que se puede seleccionar plaza es el autobus, el resto de
			 * transportes será la agencia de viajes quién asigne las plazas en fución del n
			 * de reserva,
			 */

			if (this.getTipoTransporte().equals(ActividadExterna.Transporte.autobus)) {
				if (!persona.getClass().getName().equals("Empleado")) {
					
					/*Solitamos la plaza al usuario*/
					int plazaDesada = elegirPlaza();
					
					/* Se reservan las primeras plazas del autobus a los empleados */

				}

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
					/*
					 * Para los empleados comprabamos que no sea la primera reserva de empleados
					 * empezando por el límite de getnumero de plazas
					 */
					if (!this.getListaReservas().containsKey(this.getNumeroPlazas() + 1)) {
						this.getListaReservas().put(this.getNumeroPlazas() + 1, new Reserva(persona, this));
					} else {
						/*
						 * En caso de que haya una reserva de empleado hecha, solo tenemos que coger la
						 * clave más alta de nuestro mapa y sumarle uno a la clave
						 */
						valorUltimaReserva = this.getListaReservas().lastKey();
						this.getListaReservas().put(valorUltimaReserva + 1, new Reserva(persona, this));
					}
				}
			}
		}

	}

}
