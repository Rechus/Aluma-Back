package asociacion.aluma.gestorActividades;

import asociacion.aluma.gestorActividades.actividades.Actividad;

public interface GestorActividades {

	public void addActividad(Actividad actividad);

	public Actividad getActividad(String nombre);

	public void removeActividad(String nombre);

}
