package asociacion.aluma.gestorMiembros.personas;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.InheritanceType;

import asociacion.aluma.gestorActividades.actividades.ActividadImp;
import asociacion.aluma.gestorActividades.gestorReservas.Reserva;



@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="PERS_TIPO")
@Table(name="PERSONAS")
public class Persona {

	public static enum Sexo {
		mujer, hombre
	}
	
	@Id
	@Column(name= "PERS_DNI")
	private String dni;
	@Column(name="PERS_TIPO")
	protected String tipo;
	private String nombre;
	private String primerApello;
	private String segundoApellido;
	private Instant fechaNacimiento;
	private Sexo sexo;
	
	@OneToMany(mappedBy="numeroReserva")
	private Collection<Reserva> listaReservas;
	
	@ManyToMany(targetEntity=ActividadImp.class)
	private Collection<ActividadImp> actividades;
	

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
	

	public Collection<Reserva> getListaReservas() {
		return listaReservas;
	}

	public Collection<ActividadImp> getActividades() {
		return actividades;
	}

	public Persona(String dni, String nombre, String primerApello, String segundoApellido, Instant fechaNacimiento,
			Sexo sexo) {

		this.dni = dni;
		this.nombre = nombre;
		this.primerApello = primerApello;
		this.segundoApellido = segundoApellido;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.listaReservas = new ArrayList<>();
		this.actividades = new ArrayList<>();
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

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + ", primerApello=" + primerApello + ", sexo=" + sexo + "]";
	}
	
}
