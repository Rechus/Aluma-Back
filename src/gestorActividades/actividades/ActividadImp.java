package gestorActividades.actividades;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

import gestorActividades.gestorReservas.Reserva;
import gestorMiembros.personas.Empleado;
import gestorMiembros.personas.Persona;

public abstract class ActividadImp implements Actividad {

	private String nombre;
	private Instant fecha;
	private int numeroPlazas;
	private double precio;
	private Collection<Persona> listaParticipantes;
	private Collection<Reserva> listaReservas;
	private int reservaPlazasEmpleados;

	public String getNombre() {
		return nombre;
	}

	public Instant getFecha() {
		return fecha;
	}

	public void setDate(Instant fecha) {
		this.fecha = fecha;
	}

	public int getNumeroPlazas() {
		return numeroPlazas;
	}

	public int getNumeroPlazasNoEmp() {
		return numeroPlazas - reservaPlazasEmpleados;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
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

	public Collection<Persona> getListaParticipantes() {
		return listaParticipantes;
	}

	public Collection<Reserva> getListaReservas() {
		return listaReservas;
	}

	public ActividadImp(String nombre, Instant fecha, int numeroPlazas, double precio, int reservaPlazasEmpleados) {
		super();
		this.nombre = nombre;
		this.fecha = fecha;
		this.numeroPlazas = numeroPlazas;
		this.precio = precio;
		this.listaParticipantes = new ArrayList<>();
		this.listaReservas = new ArrayList<>();
		this.reservaPlazasEmpleados = reservaPlazasEmpleados;
	}

	public boolean reservar(Persona persona) {
		if (comprobarReserva(persona)) {
			return false;
		} else {
			if (comprobarDisponbilidad(persona)) {
				getListaReservas().add(new Reserva(persona, this));
				return true;
			} else {
				return false;
			}
		}
	}

	public void confirmarReserva(Persona persona) {
		getListaReservas().stream().filter(r -> r.getPersona().equals(persona)).findFirst().ifPresent(r -> {
			r.setConfirmado(true);
			getListaParticipantes().add(persona);
		});
	}

	public boolean comprobarReserva(Persona persona) {
		return getListaReservas().stream().anyMatch(r -> r.getPersona().equals(persona));
	}

	public boolean comprobarDisponbilidad(Persona persona) {
		if (persona.getClass().equals(Empleado.class)) {
			return getListaReservas().stream().filter(r -> r.getPersona().getClass().equals(Empleado.class))
					.count() < getReservaPlazasEmpleados();
		} else {
			return getListaReservas().stream().filter(r -> !(r.getPersona().getClass().equals(Empleado.class)))
					.count() < getNumeroPlazasNoEmp();
		}
	}
}
