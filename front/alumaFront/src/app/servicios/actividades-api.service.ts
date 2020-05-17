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
const url_base_locales = "http://localhost:8080/api/locales";
const url_base_externas = "http://localhost:8080/api/externas";

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

  crearActividadLocal(actividad: Local) {
    return this.http.post(url_base_locales, actividad);
  }

  crearActividadExterna(actividad: Externa) {
    return this.http.post(url_base_externas, actividad);
  }

  modificarActividadLocal(id: any, actividad: Local) {
    return this.http.patch(`${url_base_locales}/${id}`, actividad );
  }

  modificarActividadExterna(id: any, actividad: Externa) {
    return this.http.patch(`${url_base_externas}/${id}`, actividad );
  }

  getSociosPorActividadLocal(id: any) {
    return this.http.get(`${url_base_locales}/${id}/listaParticipantes`).pipe(
      map(respuesta => respuesta['_embedded'].socios)
    )
  }
  getPersonasPorActividadLocal(id: any) {
    return this.http.get(`${url_base_locales}/${id}/listaParticipantes`).pipe(
      map(respuesta => respuesta['_embedded'].personas)
    )
  }
  getMiembrosPorActividadLocal(id: any) {
    return this.http.get(`${url_base_locales}/${id}/listaParticipantes`).pipe(
      map(respuesta => respuesta['_embedded'].miembros)
    )
  }

  getAcompanantesPorActividadLocal(id: any) {
    return this.http.get(`${url_base_locales}/${id}/listaParticipantes`).pipe(
      map(respuesta => respuesta['_embedded'].acompanantes)
    )
  }

  getReservasPorActividadLocal(id:any) {
    return this.http.get(`${url_base_locales}/${id}/listaReservas`).pipe(
      map(respuesta => respuesta['_embedded'].reservas)
    )
  }

  getParticipantesActividadExterna(id: any) {
    return this.http.get(`${url_base_externas}/${id}/listaParticipantes`)
  }

  getReservasPorActividadExterna(id: any) {
    return this.http.get(`${url_base_externas}/${id}/listaReservas`).pipe(
      map(respuesta => respuesta['_embedded'].reservas)
    )
  }

  getSociosPorActividadExterna(id: any) {
    return this.http.get(`${url_base_externas}/${id}/listaParticipantes`).pipe(
      map(respuesta => respuesta['_embedded'].socios)
    )
  }
  getPersonasPorActividadExterna(id: any) {
    return this.http.get(`${url_base_externas}/${id}/listaParticipantes`).pipe(
      map(respuesta => respuesta['_embedded'].personas)
    )
  }
  getMiembrosPorActividadExterna(id: any) {
    return this.http.get(`${url_base_externas}/${id}/listaParticipantes`).pipe(
      map(respuesta => respuesta['_embedded'].miembros)
    )
  }
  getAcompanantesPorActividadExterna(id: any) {
    return this.http.get(`${url_base_externas}/${id}/listaParticipantes`).pipe(
      map(respuesta => respuesta['_embedded'].acompanantes)
    )
  }

  getIdActividad(actividad){
    let href = actividad['_links'].self.href;
    return href.slice(href.lastIndexOf('/')+1);
  }

  borrarActividadLocal(id: any): Observable<Object> {
    return this.http.delete(`${url_base_locales}/${id}`);
  }

  borrarActividadExterna(id: any): Observable<Object> {
    return this.http.delete(`${url_base_externas}/${id}`);
  }

}
