package gestorMiembros.personas;

import java.util.Date;

public class Socio extends Persona{
	
	private String numeroSocio;

	public String getNumeroSocio() {
		return numeroSocio;
	}

	public Socio(String dni, String nombre, String primerApello, String segundoApellido, Date fechaNacimiento, Sexo sexo,
			String numeroSocio) {
		super(dni, nombre, primerApello, segundoApellido, fechaNacimiento, sexo);
		this.numeroSocio = numeroSocio;
	}

	

	
	
	
	

}
