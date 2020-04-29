package asociacion.aluma.gestorActividades.actividades.transporte;

public interface Transporte {

	public String getTipo();

	public int getAsientos();

	public boolean ocuparAsiento(int asiento);
}
