import java.time.Instant;


import gestorActividades.GestorActividadesImp;
import gestorActividades.actividades.ActividadExterna.Transporte;
import gestorMiembros.personas.Acompañante;
import gestorMiembros.personas.Empleado;
import gestorMiembros.personas.Persona.Sexo;
import gestorMiembros.personas.Socio;

public class AlumaMain {

	public static void main(String[] args) {
		GestorActividadesImp gestorActividadesImp = new GestorActividadesImp();
		
		// Creamos una actividad local
		double precios[] = { 10 , 15, 20 };
		gestorActividadesImp.crearActividad("Visita Alhambra", Instant.now() , 5,  precios, 2);
		
		// Creamos una actividad externa
		
		gestorActividadesImp.crearActividad("Visita a Sierra Nevada", Instant.now() , 20 , precios, 4 , "Monachil", Transporte.autobus);
		
		// Creamos otra actividad local
		gestorActividadesImp.crearActividad("Visita Albaicín", Instant.now() , 5 ,  precios, 1);
		
		System.out.println("====PRUEBA DE CREACCIÓN DE ACTIVIDADES====\n");
		System.out.println(gestorActividadesImp.toString());
		
		// Prueba de borrado de actividades
		System.out.println("====PRUEBA DE BORRADO DE ACTIVIDADES ====\n");
		gestorActividadesImp.borrarActividad("Visita Albaicín");
		
		System.out.println(gestorActividadesImp.toString());
		
		// Creamos varios tipos de persona para pobrar las reservas
		
		Empleado empleado1 = new Empleado("1234567A", "Cloud", "Strife", " ", Instant.now(), Sexo.hombre, "Secretario");
		Empleado empleado2 = new Empleado("1234568A", "Aeris", "Gainsborough", " ", Instant.now(), Sexo.mujer, "Tesorera");
		Empleado empleado3 = new Empleado("1233345A", "Vicent", "Valentine", " ", Instant.now(), Sexo.hombre, "Presidente");
		Socio socio1 = new Socio("1234569A", "Tifa", "Lockhart", " ", Instant.now(), Sexo.mujer, "001");
		Socio socio2 = new Socio("1234580A", "Barret", "Wallace", " ", Instant.now(), Sexo.hombre, "002");
		Acompañante aco1 = new Acompañante("0000013A", "Nanaki", "Red XIII", " ", Instant.now(), Sexo.hombre, socio1);
		Acompañante aco2 = new Acompañante("7283927A", "Cid", "Highwind", " ", Instant.now(), Sexo.hombre, socio2);
		
		// Prueba de actividad local
		System.out.println("====PRUEBA DE ACTIVIDAD LOCAL====\n");
		
		System.out.println("---Prueba reserva empleados---\n");
		gestorActividadesImp.getActividad("Visita Alhambra").reservar(empleado1);
		System.out.println(gestorActividadesImp.getActividad("Visita Alhambra").listarReservas());
		
		System.out.println("---Prueba intentar reservar misma persona---\n");
		gestorActividadesImp.getActividad("Visita Alhambra").reservar(empleado1);
		System.out.print("\n");
		gestorActividadesImp.getActividad("Visita Alhambra").reservar(empleado2);
		System.out.println(gestorActividadesImp.getActividad("Visita Alhambra").listarReservas());
		
		System.out.println("---Prueba superar limite reservas empleados---\n");
		gestorActividadesImp.getActividad("Visita Alhambra").reservar(empleado3);
		System.out.print("\n");
		System.out.println(gestorActividadesImp.getActividad("Visita Alhambra").listarReservas());
		
		System.out.println("---Prueba reservas no empleados---\n");
		gestorActividadesImp.getActividad("Visita Alhambra").reservar(socio1);
		gestorActividadesImp.getActividad("Visita Alhambra").reservar(socio2);
		gestorActividadesImp.getActividad("Visita Alhambra").reservar(aco1);
		System.out.println(gestorActividadesImp.getActividad("Visita Alhambra").listarReservas());
		
		System.out.println("---Prueba superar limite reservas---\n");
		gestorActividadesImp.getActividad("Visita Alhambra").reservar(aco2);
		System.out.println(gestorActividadesImp.getActividad("Visita Alhambra").listarReservas());
		
		System.out.println("---Prueba confirmación reservas---\n");
		gestorActividadesImp.getActividad("Visita Alhambra").confirmarReserva(empleado1);
		gestorActividadesImp.getActividad("Visita Alhambra").confirmarReserva(empleado2);
		gestorActividadesImp.getActividad("Visita Alhambra").confirmarReserva(socio2);
		System.out.println(gestorActividadesImp.getActividad("Visita Alhambra").listarReservas());
		System.out.println(gestorActividadesImp.getActividad("Visita Alhambra").listarParticipantes());
		
	}

}
