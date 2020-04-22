package gestorMiembros.personas;

import java.time.Instant;

public class Acompanante extends Persona {

	private Socio socioDependiente;

	public Socio getSocioDependiente() {
		return socioDependiente;
	}

	public Acompanante(String dni, String nombre, String primerApello, String segundoApellido, Instant fechaNacimiento,
			Sexo sexo, Socio socioDependiente) {
		super(dni, nombre, primerApello, segundoApellido, fechaNacimiento, sexo);
		this.socioDependiente = socioDependiente;
	}
}
