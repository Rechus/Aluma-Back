/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package asociacion.aluma;

import java.time.Instant;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import asociacion.aluma.gestorActividades.GestorActividadesImp;
import asociacion.aluma.gestorActividades.actividades.ActividadExterna;
import asociacion.aluma.gestorActividades.actividades.ActividadLocal;
import asociacion.aluma.gestorActividades.actividades.repositorio.ActividadExternaDAO;
import asociacion.aluma.gestorActividades.actividades.repositorio.ActividadLocalDAO;
import asociacion.aluma.gestorActividades.actividades.transporte.Autobus;
import asociacion.aluma.gestorActividades.actividades.transporte.Transporte;
import asociacion.aluma.gestorMiembros.personas.Acompanante;
import asociacion.aluma.gestorMiembros.personas.Empleado;
import asociacion.aluma.gestorMiembros.personas.Persona;
import asociacion.aluma.gestorMiembros.personas.Socio;
import asociacion.aluma.gestorMiembros.personas.repositorio.AcompananteDAO;
import asociacion.aluma.gestorMiembros.personas.repositorio.EmpleadoDAO;
import asociacion.aluma.gestorMiembros.personas.repositorio.PersonaDAO;
import asociacion.aluma.gestorMiembros.personas.repositorio.SocioDAO;

@SpringBootApplication
@ImportResource({ "classpath:config/jpa-config.xml" })
public class App {

	private static final Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
    	ConfigurableApplicationContext context  =
    			SpringApplication.run(App.class, args);
    	
    
    	Transporte autobus = new Autobus("Autobus 50 plazas", 50);
    	ActividadLocal actividad = new ActividadLocal("Visita A Granada", Instant.now(), 10, 2, 1);
    	ActividadExterna actividadE = new ActividadExterna("Alpujarras", Instant.now(), 50, 10, 5, "Alpujarras", autobus);
       	ActividadLocalDAO actividadDAO = context.getBean(ActividadLocalDAO.class);
       	ActividadExternaDAO actividadEDAO = context.getBean(ActividadExternaDAO.class);
       	Persona persona = new Persona("45107013A" , "Juan" , "Canela", "y Ole", Instant.now(), Persona.Sexo.hombre);
       	Empleado empleado = new Empleado("DNI 2" , "Pepe" , "Listo", "Karma", Instant.now(), Persona.Sexo.hombre, "Presidente");
       	Socio socio = new Socio("DNI 3" , "Carlos" , "Moro", "Ves", Instant.now(), Persona.Sexo.hombre, "NUM SOCIO 1");
       	Acompanante acompanante = new Acompanante("DNI 4" , "Naya" , "Bendisiones", "Adiosito", Instant.now(), Persona.Sexo.mujer, socio);
       	PersonaDAO personaDAO = context.getBean(PersonaDAO.class);
       	EmpleadoDAO empleadoDAO = context.getBean(EmpleadoDAO.class);
       	SocioDAO socioDAO = context.getBean(SocioDAO.class);
       	AcompananteDAO acompananteDAO = context.getBean(AcompananteDAO.class);
       	actividad.reservar(persona);
       	actividad.reservar(empleado);
       	actividad.reservar(socio);
       	actividad.reservar(acompanante);
       	actividad.confirmarReserva(persona);
       	actividad.confirmarReserva(empleado);
       	actividad.confirmarReserva(socio);
       	actividad.confirmarReserva(acompanante);
     	
    	personaDAO.save(persona);
    	empleadoDAO.save(empleado);
    	socioDAO.save(socio);
    	acompananteDAO.save(acompanante);   	
       	
    	actividadDAO.save(actividad);
    	actividadEDAO.save(actividadE);
    	
//    	List<ActividadLocal> actividades = actividadDAO.findAll();
//    	actividades.stream().map(ActividadLocal::toString).forEach(log::info);
    	
    	context.close();
    }
}
