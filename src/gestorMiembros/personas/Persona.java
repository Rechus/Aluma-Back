package gestorMiembros.personas;

import java.time.Instant;

public class Persona {

	public static enum Sexo {
		mujer, hombre
	}

	private String dni;
	private String nombre;
	private String primerApello;
	private String segundoApellido;
	private Instant fechaNacimiento;
	private Sexo sexo;

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPrimerApello() {
		return primerApello;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public Instant getFechaNacimiento() {
		return fechaNacimiento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public Persona(String dni, String nombre, String primerApello, String segundoApellido, Instant fechaNacimiento,
			Sexo sexo) {

		this.dni = dni;
		this.nombre = nombre;
		this.primerApello = primerApello;
		this.segundoApellido = segundoApellido;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		Persona other = (Persona) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

}
