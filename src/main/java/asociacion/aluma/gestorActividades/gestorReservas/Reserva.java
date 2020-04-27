package asociacion.aluma.gestorActividades.gestorReservas;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import asociacion.aluma.gestorActividades.actividades.Actividad;
import asociacion.aluma.gestorActividades.actividades.ActividadImp;
import asociacion.aluma.gestorMiembros.personas.Persona;

@Entity
public class Reserva {
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="PER")
	private Persona persona;
	private Instant fecha;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ACT")
	private ActividadImp actividad;
	private boolean confirmado;
	@Id
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

	public void setActividad(ActividadImp actividad) {
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

	public Reserva(Persona persona, ActividadImp actividad) {
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
