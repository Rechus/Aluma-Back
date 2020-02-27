package comun.clasesPersonas;

import java.util.Date;

public  class Persona {
	
	private String dni;
	private String nombre;
	private String primerApello;
	private String segundoApellido;
	private Date fechaNacimiento;
	private Sexo sexo;
	public enum Sexo { mujer , hombre }
	
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
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public Persona(String dni, String nombre, String primerApello, String segundoApellido, Date fechaNacimiento, Sexo sexo) {
		
		this.dni = dni;
		this.nombre = nombre;
		this.primerApello = primerApello;
		this.segundoApellido = segundoApellido;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
	}
	
	
	
	
	
	

}
