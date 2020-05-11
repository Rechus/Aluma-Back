import { Actividad } from './../modelo/actividad';
import { Observable } from 'rxjs';
export abstract class ActividadesService{

    abstract getActividades(): Observable<Actividad[]> ;
    
    abstract getActividadesConNombre(filtro);

    abstract crearActividad(actividad);


}