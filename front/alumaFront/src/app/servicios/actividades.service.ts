export abstract class ActividadesService{

    abstract getActividades();
    
    abstract getActividadesConNombre(filtro);

    abstract crearActividad(actividad);

}