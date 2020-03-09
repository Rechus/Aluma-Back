package gestorActividades.actividades;

import java.time.Instant;
import java.util.Map.Entry;



import java.util.TreeMap;

import gestorActividades.gestorReservas.Reserva;
import gestorMiembros.personas.Persona;



public abstract class ActividadImp implements Actividad{
	
	private String nombre;
	private Instant fecha;
	private int numeroPlazas;
	private double[] precio;
	private TreeMap<Integer , Persona> listaParticipantes;	
	private TreeMap<Integer , Reserva> listaReservas;
	// Número de plazas reservadas para empleados
	private int reservaPlazasEmpleados;
		
	public String getNombre() {
		return nombre;
	}
	
	public Instant getFecha() {
		return fecha;
	}
	public void setFechaYHoraDate(Instant fecha) {
		this.fecha = fecha;
	}
	
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
		/* Vinculamos un entero a las listas tanto de reservas como de personas para asociarlas
		 *  la reserva 1 corresponderá a la persona 1 de la lista. También con está implementación
		 *  asociamos el número de la lista de participantes al asiento que corresponda en el medio
		 *  de transporte */
		this.listaParticipantes = new TreeMap<Integer , Persona>();
		this.listaReservas = new TreeMap<Integer , Reserva>();
		this.reservaPlazasEmpleados = reservaPlazasEmpleados;
	}
	
	public abstract void reservar(Persona persona);
	
	/* Usamos un array para almacenar los diferentes precios de la actividad, así si se 
	 * necesita añadir más tipos de precios, es fácilmente escalable */
	
	public void setPrecio(double precioSocio, double precioAcom , double precioNosocio) {
		this.precio[0] = precioSocio;
		this.precio[1] = precioAcom;
		this.precio[2] = precioNosocio;
	}
	
	
	/* Método para confirmar la reserva, cuando el personal administrativo haya revisado que el pago ha sido
	 * realizado, la reserva pasa a estar confirmada  y se añade la persona a la lista de participantes */
	
	public void confirmarReserva(Persona persona) {
		int numeroReserva = 0;
		/* Recorremos la lista de reservas para ver si la persona dada tiene reserva o no */
		for (Reserva reserva : this.getListaReservas().values()) {
			if(persona.getDni().equals(reserva.getPersona().getDni())) {
				/* En caso de encontrarla cambia el estado a confirmado */
				reserva.setConfirmado(true);
				/* Necesitamos saber la clave de la reserva para porteriormente usarla para
				 * asociarla a la lista de participantes con la misma clave */ 
					numeroReserva = reserva.getNumeroReserva();
				
				// añadimos a la persona a la lista de participantes
			this.getListaParticipantes().put(numeroReserva, reserva.getPersona());
				
			}else {
				System.out.println("La persona introducida no tiene ninguna reserva asociada para esta actividad");
			}
		}
	}
	
}
	
	
	
	
	


