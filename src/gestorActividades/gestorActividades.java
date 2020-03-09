package gestorActividades;

import gestorActividades.actividades.Actividad;

public interface gestorActividades {
	public void crearActividad(Actividad actividad);
	public Actividad getActividad(Actividad actividad);
	public void borrarActividad(Actividad actividad);
	
}
