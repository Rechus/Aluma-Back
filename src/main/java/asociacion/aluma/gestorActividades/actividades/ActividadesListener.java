package asociacion.aluma.gestorActividades.actividades;

import java.time.Instant;

import javax.persistence.PrePersist;

import org.springframework.stereotype.Component;

@Component
public class ActividadesListener {

	
	@PrePersist
	void controlPrevioDatos(ActividadImp actividad) {
		
		// Control de plazas reservadas para la junta no superen nunca el 50%
		if(actividad.getReservaPlazasEmpleados() >= actividad.getNumeroPlazas()*0.5) {
			actividad.setReservaPlazasEmpleados(actividad.getNumeroPlazas() / 2);
		}
		// Control de nombres vacios
		if(actividad.getNombre() == ""){
			actividad.setNombre("Actividad sin nombre creada el: " + Instant.now());
		}
		
		// Control de fechas vacias
		if(actividad.getFecha() == null) {
			actividad.setDate(Instant.now());
		}
	}	
}
