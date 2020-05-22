import { Component, OnInit } from '@angular/core';
import { ActividadesService } from 'src/app/servicios/actividades.service';
import { Local } from 'src/app/modelo/Local';
import { Externa } from 'src/app/modelo/Externa';

@Component({
  selector: 'app-actividades-lista',
  templateUrl: './actividades-lista.component.html',
  styleUrls: ['./actividades-lista.component.css']
})
export class ActividadesListaComponent implements OnInit {

  actividadesListaLocales: Local[] = [];
  actividadesListaExternas: Externa[] = [];

  constructor(public actividadesService: ActividadesService) { 
  }

  ngOnInit(): void {
    this.actividadesService.getActividadesLocales().subscribe(
      respuesta =>{
        if(respuesta){
          this.actividadesListaLocales = respuesta;
        }else{
          this.actividadesListaLocales = [];
        }
      } 
    )
    this.actividadesService.getActividadesExternas().subscribe(
      respuesta =>{
        if(respuesta){
          this.actividadesListaExternas = respuesta;
        }else{
          this.actividadesListaExternas = [];
        }
      }
    )
  }

  esPasado(actividad){
    let fechaActividad = new Date(actividad.fecha);
    return fechaActividad < new Date();
  }

  filtrar(filtro?){
    if (!filtro || filtro.trim().lenght == 0 ){
      this.actividadesService.getActividadesLocales().subscribe(
        respuesta => this.actividadesListaLocales = respuesta
      )
      this.actividadesService.getActividadesExternas().subscribe(
        respuesta => this.actividadesListaExternas = respuesta
      )
    }else{
      this.actividadesService.getActividadesConNombreLocal(filtro).subscribe(
        respuesta  =>  (respuesta == null) ? this.actividadesListaLocales = []
        : this.actividadesListaLocales = respuesta
      ) ;
      this.actividadesService.getActividadesConNombreExterna(filtro).subscribe(
        respuesta  =>  (respuesta == null) ? this.actividadesListaExternas = []
        : this.actividadesListaExternas = respuesta
      ) ;
    }
  }
}
