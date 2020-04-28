package asociacion.aluma.gestorMiembros.personas;

import java.time.Instant;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="EMPLEADOS")
public class Empleado extends Persona {

	private String puesto;

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public Empleado(String dni, String nombre, String primerApello, String segundoApellido, Instant fechaNacimiento,
			Sexo sexo, String puesto) {
		super(dni, nombre, primerApello, segundoApellido, fechaNacimiento, sexo);
		this.puesto = puesto;
	}
	
	public Empleado() {
		
	}
	
}
