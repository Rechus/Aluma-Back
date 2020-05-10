import { actividades_data } from './../data/actividades.data';
import { Injectable } from '@angular/core';
import { ActividadesService } from './actividades.service';


@Injectable()
export class ActividadesOffService extends ActividadesService {

  actividades = actividades_data;

  constructor() { 
    super();
  }

  getActividades(){
    return this.actividades;
  }

  getActividadesConNombre(filtro){
    return this.actividades.filter(

      (actividad) => {
        let contieneNombre = actividad.nombre.toUpperCase().includes(filtro.toUpperCase());
        return contieneNombre;
      }
    )
  }

  crearActividad(actividad){
    this.actividades.push(actividad);
  }

}
