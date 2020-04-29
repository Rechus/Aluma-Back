package asociacion.aluma.gestorActividades.gestorReservas;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import asociacion.aluma.gestorActividades.actividades.Actividad;
import asociacion.aluma.gestorActividades.actividades.ActividadImp;
import asociacion.aluma.gestorMiembros.personas.Persona;

@Entity
public class Reserva {

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PER")
	private Persona persona;
	private Instant fecha;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACT")
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

	public Reserva(Persona persona, ActividadImp actividad, int numeroReserva) {
		super();
		this.persona = persona;
		this.actividad = actividad;
		this.fecha = Instant.now();
		this.confirmado = false;
		this.numeroReserva = numeroReserva;
	}

	public Reserva() {
	}

	@Override
	public String toString() {
		return "Reserva [getPersona()=" + getPersona() + ", getActividad()=" + getActividad() + ", isConfirmado()="
				+ isConfirmado() + ", getNumeroReserva()=" + getNumeroReserva() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroReserva;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reserva other = (Reserva) obj;
		if (numeroReserva != other.numeroReserva)
			return false;
		return true;
	}
}
