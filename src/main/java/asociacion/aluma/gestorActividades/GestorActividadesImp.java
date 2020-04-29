package asociacion.aluma.gestorActividades;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import asociacion.aluma.gestorActividades.actividades.Actividad;
import asociacion.aluma.gestorActividades.actividades.ActividadExterna;
import asociacion.aluma.gestorActividades.actividades.ActividadImp;
import asociacion.aluma.gestorActividades.actividades.ActividadLocal;
import asociacion.aluma.gestorActividades.actividades.transporte.Transporte;

public class GestorActividadesImp implements GestorActividades {

	private Collection<Actividad> listaActividades;

	public Collection<Actividad> getListaActividades() {
		return listaActividades;
	}

	public GestorActividadesImp() {

		this.listaActividades = new ArrayList<Actividad>();
	}

	public void crearActividad(String nombre, Instant fecha, int numeroPlazas, double precio,
			int reservaPlazasEmpleados) {
		ActividadLocal actividad = new ActividadLocal(nombre, fecha, numeroPlazas, precio, reservaPlazasEmpleados);
		this.getListaActividades().add(actividad);
	}

	public void crearActividad(String nombre, Instant fecha, int numeroPlazas, double precio,
			int reservaPlazasEmpleados, String destino, Transporte transporte) {
		ActividadExterna actividad = new ActividadExterna(nombre, fecha, numeroPlazas, precio, reservaPlazasEmpleados,
				destino, transporte);
		this.getListaActividades().add(actividad);
	}

	@Override
	public void addActividad(Actividad actividad) {

		this.getListaActividades().add(actividad);
	}

	@Override
	public ActividadImp getActividad(String nombre) {
		for (Actividad actividad : this.getListaActividades()) {
			if (actividad.getNombre().equals(nombre)) {
				return (ActividadImp) actividad;
			}
		}
		return null;
	}

	@Override
	public void removeActividad(String nombre) {
		// creamos el iterador y copiamos nuestra lista
		Iterator<Actividad> recorrer = this.getListaActividades().iterator();
		while (recorrer.hasNext()) {
			Actividad actividad = recorrer.next();
			if (actividad.getNombre() == nombre) {
				recorrer.remove();
			}
		}
	}
}
