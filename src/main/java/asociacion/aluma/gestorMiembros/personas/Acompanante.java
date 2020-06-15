package asociacion.aluma.gestorMiembros.personas;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ACOMPANANTES")
public class Acompanante extends Persona {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SOCIO_DEP")
	private Socio socioDependiente;

	public Socio getSocioDependiente() {
		return socioDependiente;
	}

	public Acompanante(String dni, String nombre, String primerApello, String segundoApellido, Instant fechaNacimiento,
			Sexo sexo, Socio socioDependiente) {
		super(dni, nombre, primerApello, segundoApellido, fechaNacimiento, sexo);
		this.socioDependiente = socioDependiente;
	}

	public Acompanante() {
	}
}
