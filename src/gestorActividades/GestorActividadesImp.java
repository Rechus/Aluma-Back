package gestorActividades;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collection;

import gestorActividades.actividades.Actividad;
import gestorActividades.actividades.ActividadExterna;

import gestorActividades.actividades.ActividadLocal;

import gestorActividades.gestorReservas.GestorReservaImp;

public class GestorActividadesImp implements gestorActividades {

	private GestorReservaImp gestorReserva;
	private Collection<Actividad> listaActividades;
	
	
	public GestorReservaImp getGestorReserva() {
		return gestorReserva;
	}



	public void setGestorReserva(GestorReservaImp gestorReserva) {
		this.gestorReserva = gestorReserva;
	}



	public Collection<Actividad> getListaActividades() {
		return listaActividades;
	}
	


	public GestorActividadesImp() {
		this.gestorReserva = new GestorReservaImp();
		this.listaActividades = new ArrayList<Actividad>();
	}
	
	
	/* Sobrecargamos crear actividad para los diferentes tipo  de esta */
	public void crearActividad(String nombre , Instant fecha , int numeroPlazas ,  double [] precio , int reservaPlazasEmpleados) {
		ActividadLocal actividad = new ActividadLocal(nombre, fecha, numeroPlazas, precio, reservaPlazasEmpleados);
		this.getListaActividades().add(actividad);
	}
	
	public void crearActividad(String nombre , Instant fecha , int numeroPlazas ,  double [] precio , int reservaPlazasEmpleados
			, String destino , ActividadExterna.Transporte transporte) {
		ActividadExterna actividad = new ActividadExterna(nombre, fecha, numeroPlazas, precio, reservaPlazasEmpleados, destino, transporte);
		this.getListaActividades().add(actividad);
	}

	@Override
	public void crearActividad(Actividad actividad) {
		
		this.getListaActividades().add(actividad);
	}

	@Override
	public Actividad getActividad(Actividad actividadBuscada) {
		for(Actividad actividad : this.getListaActividades()) {
			if (actividad.equals(actividadBuscada)) {
				return actividad;
			}
		}
		return null;
	}

	@Override
	public void borrarActividad(Actividad actividadEliminar) {
		for (Actividad actividad : listaActividades) {
			if (actividad.getNombre().equals(actividadEliminar.getNombre())) {
				listaActividades.remove(actividad);
			}
		}
	}



	


	

	
}
