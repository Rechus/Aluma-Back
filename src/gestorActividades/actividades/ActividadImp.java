package gestorActividades.actividades;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import gestorActividades.gestorReservas.Reserva;
import gestorMiembros.personas.Persona;


public abstract class ActividadImp implements Actividad{
	
	private String nombre;
	private Date fecha;
	private int numeroPlazas;
	private double[] precio;
	private TreeMap<Integer , Persona> listaParticipantes;
	private TreeMap<Integer , Reserva> listaReservas;
	// Número de plazas reservadas para empleados
	private int reservaPlazasEmpleados;
		
	public String getNombre() {
		return nombre;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFechaYHoraDate(Date fecha) {
		this.fecha = fecha;
	}
	
	public int getNumeroPlazas() {
		return numeroPlazas;
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
	
	public abstract void reservar(Persona persona);
	public void setPrecio(double precioSocio, double precioAcom , double precioNosocio) {
		this.precio[0] = precioSocio;
		this.precio[1] = precioAcom;
		this.precio[2] = precioNosocio;
	}

	public ActividadImp(String nombre, Date fecha, int numeroPlazas, double[] precio, int reservaPlazasEmpleados) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.numeroPlazas = numeroPlazas;
		this.precio = precio;
		this.listaParticipantes = new TreeMap<Integer , Persona>();
		this.listaReservas = new TreeMap<Integer , Reserva>();
		this.reservaPlazasEmpleados = reservaPlazasEmpleados;
	}
	
	
	

}
	
	
	
	
	


