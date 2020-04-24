package gestorActividades.actividades;

import java.time.Instant;

import gestorActividades.gestorReservas.Reserva;
import gestorMiembros.personas.Empleado;
import gestorMiembros.personas.Persona;

public class ActividadLocal extends ActividadImp {

	public ActividadLocal(String nombre, Instant fecha, int numeroPlazas, double precio, int reservaPlazasEmpleados) {
		super(nombre, fecha, numeroPlazas, precio, reservaPlazasEmpleados);
	}

	@Override
	public String toString() {
		return "ActividadLocal [getNombre()=" + getNombre() + ", getFecha()=" + getFecha() + ", getNumeroPlazas()="
				+ getNumeroPlazas() + ", getNumeroPlazasNoEmp()=" + getNumeroPlazasNoEmp() + ", getPrecio()="
				+ getPrecio() + ", getReservaPlazasEmpleados()=" + getReservaPlazasEmpleados() + "]";
	}
	
	
}
