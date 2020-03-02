package gestorMiembros.personas;

import java.util.Date;

public class Acompañante extends Persona{

	private Socio socioDependiente;

	public String getNumeroSocioDependiente() {
		return socioDependiente.getNumeroSocio();
	}
	
	public Socio getSocioDependiente() {
		return socioDependiente;
	}



	public Acompañante(String dni, String nombre, String primerApello, String segundoApellido, Date fechaNacimiento, Sexo sexo,
			Socio socioDependiente) {
		super(dni, nombre, primerApello, segundoApellido, fechaNacimiento, sexo);
		this.socioDependiente = socioDependiente;
	}
	
	
}
