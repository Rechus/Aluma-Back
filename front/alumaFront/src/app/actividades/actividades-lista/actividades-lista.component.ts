import { Actividad } from './../../modelo/actividad';
import { Component, OnInit } from '@angular/core';
import { ActividadesService } from 'src/app/servicios/actividades.service';
import { fileURLToPath } from 'url';

@Component({
  selector: 'app-actividades-lista',
  templateUrl: './actividades-lista.component.html',
  styleUrls: ['./actividades-lista.component.css']
})
export class ActividadesListaComponent implements OnInit {

  actividadesLista: Actividad[];

  constructor(private actividadesService: ActividadesService) { 
  }

  ngOnInit(): void {
    this.actividadesService.getActividades().subscribe(
      respuesta => (this.actividadesLista = respuesta)
    )
  }

  esPasado(actividad){
    let fechaActividad = new Date(actividad.fecha);
    return fechaActividad < new Date();
  }

  filtrar(filtro){
    if (!filtro || filtro.trim().lenght == 0 ){
      this.actividadesService.getActividades().subscribe(
        respuesta => this.actividadesLista = respuesta['_embedded'].actividades
      )
    }else{
      this.actividadesLista = this.actividadesService.getActividadesConNombre(filtro);
    }
  }

 

}
