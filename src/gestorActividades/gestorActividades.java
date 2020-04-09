package gestorActividades;

import gestorActividades.actividades.Actividad;

// Me estan sangrando los ojos ahora mismo:
// Como puedes usar lowerCamelCase aqui? Es una cagada muy gorda
public interface gestorActividades {
	// Parece que la Actividad ya estara creada. No sera addActividad?
	public void crearActividad(Actividad actividad);
	public Actividad getActividad(String nombre);
	// Yo hay nombres que suelo conservar: get, set, add, is, has, o remove
	// mas que nada porque sera lo primero que busque otro para hacer esas cosas
	public void borrarActividad(String nombre);
	
}
