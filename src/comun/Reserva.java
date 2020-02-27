package comun;

import java.util.Date;

import comun.clasesPersonas.Persona;
import comun.interfaces.Reservable;

public class Reserva  implements Reservable{
	
	private static Reserva instanciaUnica;
	
	private Persona persona;
	private final Date fechaReserva;
	private Reservable reserva;
	
	
	public Persona getPersona() {
		return persona;
	}
	
	public Date getFechaReserva() {
		return fechaReserva;
	}


	public Reservable getReserva() {
		return reserva;
	}

	private Reserva (Persona persona , Reservable reserva) {
		
		this.persona = persona;
		this.fechaReserva = new Date ();
		this.reserva = reserva;
		
	}
	
	public static synchronized Reserva getInstanciaRerserva(Persona persona , Reservable reserva) {
		if (instanciaUnica == null) {
			instanciaUnica = new Reserva(persona, reserva);
		}
		
		return instanciaUnica;
	}

	@Override
	public void reservar() {
		getReserva().reservar();
		
	}
	
	
}
