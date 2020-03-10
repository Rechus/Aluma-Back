package gestorActividades;

import gestorActividades.actividades.Actividad;

public interface gestorActividades {
	public void crearActividad(Actividad actividad);
	public Actividad getActividad(String nombre);
	public void borrarActividad(String nombre);
	
}
