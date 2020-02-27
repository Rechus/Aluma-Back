package comun;

import comun.clasesPersonas.Persona;
import comun.interfaces.Reservable;

public class Plaza implements Reservable {
	
	private Actividad actividad;
	private Persona participante;
	private boolean reservado;
	private String numeroPlaza; // en el caso de ser plaza 
	
	

	public Persona getParticipante() {
		return participante;
	}

	

	public void setParticipante(Persona participante) {
		this.participante = participante;
	}


	public boolean isReservado() {
		return reservado;
	}

	public String getNumeroPlaza() {
		return numeroPlaza;
	}
		
	public void setNumeroAsiento(String numeroPlaza) {
		this.numeroPlaza = numeroPlaza;
	}
	
	
	public Actividad getActividad() {
		return actividad;
	}



	public void setActividad(Actividad actividad) {
		this.actividad = actividad;
	}



	public Plaza(Actividad actividad , Persona participante , String numeroPlaza) {
		
		this.actividad = actividad;
		this.participante = participante;
		this.reservado = false;
		this.numeroPlaza = numeroPlaza;
	}


	@Override
	public void reservar() {
				
		this.reservado = true;
		
	}
	
}
