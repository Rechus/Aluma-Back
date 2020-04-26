package asociacion.aluma.gestorActividades.actividades;

import java.time.Instant;

import asociacion.aluma.gestorActividades.actividades.transporte.Transporte;



public class ActividadExterna extends ActividadImp {

	private String destino;
	private Transporte transporte;

	public String getDestino() {
		return destino;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public ActividadExterna(String nombre, Instant fecha, int numeroPlazas, double precio, int reservaPlazasEmpleados,
			String destino, Transporte transporte) {
		super(nombre, fecha, numeroPlazas, precio, reservaPlazasEmpleados);
		this.destino = destino;
		this.transporte = transporte;
	}

	public boolean elegirPlaza(int numero) {
		return getTransporte().ocuparAsiento(numero);
	}

	@Override
	public String toString() {
		return "ActividadExterna [destino=" + destino + ", transporte=" + transporte + ", toString()="
				+ super.toString() + "]";
	}

}
