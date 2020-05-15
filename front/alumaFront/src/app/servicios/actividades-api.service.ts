import { ActivatedRoute } from '@angular/router';
import { ActividadesService } from 'src/app/servicios/actividades.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Actividades } from '../modelo/Actividades';
import { Local } from '../modelo/Local';
import { Externa } from '../modelo/Externa';

const url_base = "http://localhost:8080/api";
const url_base_actividades = "http://localhost:8080/api/actividades";

@Injectable({
  providedIn: 'root'
})
export class ActividadesApiService extends ActividadesService {
 
 

  constructor(private http: HttpClient) { 
    super();
  }

  getActividadesLocales(): Observable<Local[]> {
    return this.http.get(url_base_actividades).pipe(
    map(respuesta => respuesta['_embedded'].locales)
    )
  }

  getActividadesExternas(): Observable<Externa[]> {
    return this.http.get(url_base_actividades).pipe(
      map(respuesta => respuesta['_embedded'].externas)   
    )
    }
    
  getActividadesConNombreLocal(filtro: any): Observable<Actividades> {
    return this.http.get(`${url_base_actividades}/search/nombre?nombre=${filtro}`).pipe(
      map(respuesta => respuesta['_embedded'].locales)
    )
  }

  getActividadesConNombreExterna(filtro: any): Observable<Actividades> {
    return this.http.get(`${url_base_actividades}/search/nombre?nombre=${filtro}`).pipe(
      map(respuesta => respuesta['_embedded'].externas)
    )
  }

  getActividadPorId(id: any): Observable<Actividades>{
    return this.http.get(`${url_base_actividades}/search/id?id=${id}`).pipe(
      map(respuesta => respuesta['_embedded'].actividades)
    )
  }

  getActividadLocalPorId(id: any): Observable<Local>{
    return this.http.get(`${url_base_actividades}/search/id?id=${id}`).pipe(
      map(respuesta => respuesta['_embedded'].locales)
    )
  }

  

  getActividadExternaPorId(id: any): Observable<Externa>{
    return this.http.get(`${url_base_actividades}/search/id?id=${id}`).pipe(
      map(respuesta => respuesta['_embedded'].externas)
    )
  }

  crearActividad(actividad: any) {
    throw new Error("Method not implemented.");
  }

  modificarActividad(id: any, actividad: any) {
    throw new Error("Method not implemented.");
  }
}
