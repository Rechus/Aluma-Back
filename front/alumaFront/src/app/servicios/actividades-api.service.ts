import { ActivatedRoute } from '@angular/router';
import { ActividadesService } from 'src/app/servicios/actividades.service';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Actividad } from '../modelo/actividad';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ActividadesApiService extends ActividadesService {
  
 

  constructor(private http: HttpClient) { 
    super();
  }

  getActividades(): Observable<Actividad[]> {

    
    return this.http.get("http://localhost:8080/api/locales").pipe(
    map(respuesta => respuesta['_embedded'].locales)
    )

  }
  getActividadesConNombre(filtro: any) {
    throw new Error("Method not implemented.");
  }
  crearActividad(actividad: any) {
    throw new Error("Method not implemented.");
  }
}
