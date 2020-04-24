package gestorActividades.actividades.transporte;

public class Autobus implements Transporte {

	private String tipo;
	private int numeroAsientos;
	private boolean[] ocupacion;

	public boolean[] getOcupacion() {
		return ocupacion;
	}

	@Override
	public String getTipo() {
		return tipo;
	}

	@Override
	public int getAsientos() {
		return numeroAsientos;
	}

	public Autobus(String tipo, int numeroAsientos) {
		this.tipo = tipo;
		this.numeroAsientos = numeroAsientos;
		this.ocupacion = new boolean[numeroAsientos];
	}

	public boolean ocuparAsiento(int numero) {
		boolean ocupado = getOcupacion()[numero];
		if (ocupado) {
			return false;
		}else {
			ocupado = true;
			return true;
		}
	}
}
