
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

    abstract crearActividadLocal(actividad: Local);
    abstract crearActividadExterna(actividad: Externa);

    abstract modificarActividadLocal(id, actividad: Local);
    abstract modificarActividadExterna(id, actividad: Externa);

    abstract getReservasPorActividadLocal(id:any);
    abstract getReservasPorActividadExterna(id:any);

    abstract getSociosPorActividadLocal(id: any);
    abstract getPersonasPorActividadLocal(id: any);
    abstract getMiembrosPorActividadLocal(id: any);
    abstract getAcompanantesPorActividadLocal(id: any);
    
    abstract getSociosPorActividadExterna(id: any);
    abstract getPersonasPorActividadExterna(id: any);
    abstract getMiembrosPorActividadExterna(id: any);
    abstract getAcompanantesPorActividadExterna(id: any);

    abstract getIdActividad(actividad);
    abstract borrarActividadLocal(id: any): Observable<Object>;
    abstract borrarActividadExterna(id: any): Observable<Object>;

   

    


}