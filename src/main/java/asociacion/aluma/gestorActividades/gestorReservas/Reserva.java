package asociacion.aluma.gestorActividades.gestorReservas;

import java.time.Instant;

import asociacion.aluma.gestorActividades.actividades.Actividad;
import asociacion.aluma.gestorMiembros.personas.Persona;


public class Reserva {

	private Persona persona;
	private Instant fecha;
	private Actividad actividad;
	private boolean confirmado;
	private int numeroReserva;

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Instant getFecha() {
		return fecha;
	}

	public Actividad getActividad() {
		return actividad;
	}

	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}

	public boolean isConfirmado() {
		return confirmado;
	}

	public void setConfirmado(boolean confirmado) {
		this.confirmado = confirmado;
	}

	public int getNumeroReserva() {
		return numeroReserva;
	}

	public void setNumeroReserva(int numeroReserva) {
		this.numeroReserva = numeroReserva;
	}

	public Reserva(Persona persona, Actividad actividad) {
		super();
		this.persona = persona;
		this.actividad = actividad;
		this.fecha = Instant.now();
		this.confirmado = false;
	}

	@Override
	public String toString() {
		return "Reserva [getPersona()=" + getPersona() +  ", getActividad()="
				+ getActividad() + ", isConfirmado()=" + isConfirmado() + ", getNumeroReserva()=" + getNumeroReserva()
				+ "]";
	}
}