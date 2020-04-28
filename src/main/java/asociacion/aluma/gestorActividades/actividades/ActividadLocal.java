package asociacion.aluma.gestorActividades.actividades;

import java.time.Instant;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="ACT_LOCAL")
public class ActividadLocal extends ActividadImp {

	public ActividadLocal(String nombre, Instant fecha, int numeroPlazas, double precio, int reservaPlazasEmpleados) {
		super(nombre, fecha, numeroPlazas, precio, reservaPlazasEmpleados);
	}
	
	public ActividadLocal(){
		super();
	}

	@Override
	public String toString() {
		return "ActividadLocal [getNombre()=" + getNombre() + ", getFecha()=" + getFecha() + ", getNumeroPlazas()="
				+ getNumeroPlazas() + ", getNumeroPlazasNoEmp()=" + getNumeroPlazasNoEmp() + ", getPrecio()="
				+ getPrecio() + ", getReservaPlazasEmpleados()=" + getReservaPlazasEmpleados() + "]";
	}
	
	
}
