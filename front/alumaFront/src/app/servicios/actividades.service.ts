import { Externa } from './../modelo/Externa';

import { Observable } from 'rxjs';
import { Actividades } from '../modelo/Actividades';
import { Local } from '../modelo/Local';

export abstract class ActividadesService{

    abstract getActividadesLocales(): Observable<Local[]>;
    abstract getActividadesExternas(): Observable<Externa[]>;
    
    abstract getActividadesConNombreExterna(filtro);
    abstract getActividadesConNombreLocal(filtro);

    abstract getActividadPorId(id: any): Observable<Actividades>
    abstract getActividadLocalPorId(id: any): Observable<Local>;
    abstract getActividadExternaPorId(id: any): Observable<Externa>;

    abstract crearActividad(actividad);

    abstract modificarActividad(id, actividad);


}