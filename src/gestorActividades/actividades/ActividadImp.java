package gestorActividades.actividades;

import java.time.Instant;

import java.util.TreeMap;

import gestorActividades.gestorReservas.Reserva;
import gestorMiembros.personas.Persona;

public abstract class ActividadImp implements Actividad {

	private String nombre;
	private Instant fecha;
	private int numeroPlazas;
	// Te pongo aqui el comentario pero es tambien para todos los sitios donde se usa:
	// No me gusta nada usar un array aqui. Las posiciones no dicen nada, puede pasarse un array mas
	// largo y no aporta nada tenerlos indexados. Por que es mejor que tener 3 campos distintos?
	// o uno solo y los otros supongo que se aplicaran descuentos/bonificaciones/tasas, etc...
	// y se calcula?
	private double[] precio;
	// Usa la interface Map mejor, te estas ligando a una implementacion
	// Luego si quieres utilizala al instanciar, pero no obligues a usar esta
	// implementacion
	private TreeMap<Integer, Persona> listaParticipantes;
	private TreeMap<Integer, Reserva> listaReservas;
	// Número de plazas reservadas para empleados
	private int reservaPlazasEmpleados;

	public String getNombre() {
		return nombre;
	}

	public Instant getFecha() {
		return fecha;
	}

	// Vaya nombre!! porque no setDate?
	public void setFechaYHoraDate(Instant fecha) {
		this.fecha = fecha;
	}

	// Me parece bien usado el getter de esta forma
	public int getNumeroPlazas() {
		return numeroPlazas - reservaPlazasEmpleados;
	}

	public void setNumeroPlazas(int limitePlazas) {
		this.numeroPlazas = limitePlazas;
	}

	public int getReservaPlazasEmpleados() {
		return reservaPlazasEmpleados;
	}

	public void setReservaPlazasEmpleados(int reservaPlazasEmpleados) {
		this.reservaPlazasEmpleados = reservaPlazasEmpleados;
	}

	public TreeMap<Integer, Persona> getListaParticipantes() {
		return listaParticipantes;
	}

	public TreeMap<Integer, Reserva> getListaReservas() {
		return listaReservas;
	}

	public ActividadImp(String nombre, Instant fecha, int numeroPlazas, double[] precio, int reservaPlazasEmpleados) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.numeroPlazas = numeroPlazas;
		this.precio = precio;
		/*
		 * Vinculamos un entero a las listas tanto de reservas como de personas para
		 * asociarlas la reserva 1 corresponderá a la persona 1 de la lista. También con
		 * está implementación asociamos el número de la lista de participantes al
		 * asiento que corresponda en el medio de transporte
		 */
		// No me gusta nada. Ya te toca coordinar que no te falle esa sincronizacion.
		// La Reserva ya tiene un campo Persona que lo asocia. Por que no lo usas?
		// Lo del transporte es otra cosa. Como sabes si tendra ese numero los transportes?
		// Puede ser que vayan en varios, que no empiece por el asiento 1 (algo normal en los buses)
		// o cualquier otra cosa que te tire por tierra esto. No compliques, ni mezcles cosas
		// por que mas pronto que tarde te daras cuenta que no funciona como esperabas
		this.listaParticipantes = new TreeMap<Integer, Persona>();
		this.listaReservas = new TreeMap<Integer, Reserva>();
		this.reservaPlazasEmpleados = reservaPlazasEmpleados;
	}

	public abstract void reservar(Persona persona);

	/*
	 * Usamos un array para almacenar los diferentes precios de la actividad, así si
	 * se necesita añadir más tipos de precios, es fácilmente escalable
	 */

	public void setPrecio(double precioSocio, double precioAcom, double precioNosocio) {
		this.precio[0] = precioSocio;
		this.precio[1] = precioAcom;
		this.precio[2] = precioNosocio;
	}

	/*
	 * Método para confirmar la reserva, cuando el personal administrativo haya
	 * revisado que el pago ha sido realizado, la reserva pasa a estar confirmada y
	 * se añade la persona a la lista de participantes
	 */
	// Ya te podias haber atrevido con un lambda y quedaria
	//	getListaReservas().values().stream()
	//		.filter(r -> r.getPersona().equals(persona))
	//		.findFirst().ifPresent(r -> {
	//			r.setConfirmado(true);
	//			getListaParticipantes().put(r.getNumeroReserva(), r.getPersona());
	//		});
	public void confirmarReserva(Persona persona) {
		int numeroReserva = -1;
		/*
		 * Recorremos la lista de reservas para ver si la persona dada tiene reserva o
		 * no
		 */
		for (Reserva reserva : this.getListaReservas().values()) {
			if (reserva.getPersona().equals(persona) && reserva.isConfirmado() == false) {
				/* En caso de encontrarla cambia el estado a confirmado */
				reserva.setConfirmado(true);
				/*
				 * Necesitamos saber la clave de la reserva para porteriormente usarla para
				 * asociarla a la lista de participantes con la misma clave
				 */
				numeroReserva = reserva.getNumeroReserva();

				// añadimos a la persona a la lista de participantes
				this.getListaParticipantes().put(numeroReserva, reserva.getPersona());
				break;
			}
		}
	}

	// No hagas metodos en negocio para formatear "informes" en String
	// Tienes un metodo para devolver la coleccion y el que lo tenga que presentar que
	// lo haga como quiera en formato, idioma, agregados o que lo cocine como sea
	public String listarReservas() {
		String resultado = "";

		for (Reserva reserva : this.getListaReservas().values()) {
			resultado = resultado + "Número reserva: " + reserva.getNumeroReserva() + " DNI: "
					+ reserva.getPersona().getDni() + " fecha reserva: " + reserva.getFecha() + " Reserva confirmada: "
					+ reserva.isConfirmado() + "\n";
		}

		return "Listado de reservas:\n" + resultado;
	}

	public String listarParticipantes() {
		String resultado = "";

		for (Persona persona : this.getListaParticipantes().values()) {
			resultado = resultado + "DNI : " + persona.getDni() + " Nombre: " + persona.getNombre()
					+ " Primer Apellido: " + persona.getPrimerApello() + "\n";
		}

		return "Listado de participantes:\n" + resultado;
	}

}
