package gestorMiembros.personas;

import java.time.Instant;

// No uses caracteres especiales en los nombres (ñ)
// ni siquiera en los comentarios. Yo lo he puesto para
// que quede claro, pero con todo el dolor de mi corazon
public class Acompañante extends Persona{

	private Socio socioDependiente;

	// Yo quitaria esto. No cuesta nada hacer getSocioDependiente().getNumeroSocio()
	public String getNumeroSocioDependiente() {
		// Aqui tambien deberias usar el getter que tienes ya hecho
		return socioDependiente.getNumeroSocio();
	}
	
	public Socio getSocioDependiente() {
		return socioDependiente;
	}
	// Estos espacios en blanco eliminalos, dan muy mala impresion

	// Reduce la longitud de la linea. Nuestra guia de estilo dice maximo 100:
	// https://google.github.io/styleguide/javaguide.html#s4.4-column-limit
	// No se trata de que vayas contandolo, pero es que tengo un monitor grande y no cabe
	// en total te salen 131, pero vamos que con ponerlo en dos lineas se te hubiera quedado
	// en 95
	public Acompañante(String dni, String nombre, String primerApello, String segundoApellido, Instant fechaNacimiento, Sexo sexo,
			Socio socioDependiente) {
		super(dni, nombre, primerApello, segundoApellido, fechaNacimiento, sexo);
		this.socioDependiente = socioDependiente;
	}
	
	
}
