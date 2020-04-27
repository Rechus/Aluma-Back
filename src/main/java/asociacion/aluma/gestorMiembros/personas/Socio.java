package asociacion.aluma.gestorMiembros.personas;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("S")
@Table(name="EMPLEADOS")
public class Socio extends Persona {

	@Column(name="NUM_SOCIO")
	private String numeroSocio;
	
	@OneToMany(mappedBy="socioDependiente")
	private Collection<Acompanante> acompanantes;
	
	public Collection<Acompanante> getAcompanantes() {
		return acompanantes;
	}

	public String getNumeroSocio() {
		return numeroSocio;
	}

	public Socio(String dni, String nombre, String primerApello, String segundoApellido, Instant fechaNacimiento,
			Sexo sexo, String numeroSocio) {
		super(dni, nombre, primerApello, segundoApellido, fechaNacimiento, sexo);
		this.numeroSocio = numeroSocio;
		this.tipo = "S";
		this.acompanantes = new ArrayList<>();
	}

}
