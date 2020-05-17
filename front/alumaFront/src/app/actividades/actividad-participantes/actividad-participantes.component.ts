import { Component, OnInit } from '@angular/core';
import { Externa } from 'src/app/modelo/Externa';
import { Local } from 'src/app/modelo/Local';
import { ActividadesService } from 'src/app/servicios/actividades.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-actividad-participantes',
  templateUrl: './actividad-participantes.component.html',
  styleUrls: ['./actividad-participantes.component.css']
})
export class ActividadParticipantesComponent implements OnInit {

  nombre = "";
  idActividad;
  detalle;
  local: Local;
  externa: Externa;
  socios;
  acompanantes ;
  personas;
  miembros;

  constructor(private actividadesService:  ActividadesService,
    private ruta: ActivatedRoute,
    private  router: Router) { }

  ngOnInit(): void {
    this.socios = [];
    this.acompanantes = [];
    this.personas = [];
    this.miembros = [];
    this.idActividad = this.ruta.snapshot.paramMap.get('id');
    this.actividadesService.getActividadLocalPorId(this.idActividad).subscribe(
      (respuesta: Local) =>{
        if(respuesta){
          this.local = respuesta[0];
          this.nombre = this.local.nombre;
          this.actividadesService.getSociosPorActividadLocal(this.idActividad).subscribe(
            (respuesta2) => {
              if(respuesta2){
           
              this.socios = respuesta2;
              }
            }
          )
          this.actividadesService.getMiembrosPorActividadLocal(this.idActividad).subscribe(
            (respuesta2) => {
              if(respuesta2){
              this.miembros = respuesta2;
              }
            }
          )
          this.actividadesService.getPersonasPorActividadLocal(this.idActividad).subscribe(
            (respuesta2) => {
              if(respuesta2){
              this.personas= respuesta2;
              }
            }
          )
          this.actividadesService.getAcompanantesPorActividadLocal(this.idActividad).subscribe(
            (respuesta2) => {
              if(respuesta2){
              console.log(respuesta2);
              this.acompanantes = respuesta2;
              }
            }
          )
        }else{
          this.actividadesService.getActividadExternaPorId(this.idActividad).subscribe(
            (respuesta: Externa) =>{
              if(respuesta){
                this.externa = respuesta[0];
                this.nombre = this.externa.nombre;
                this.actividadesService.getSociosPorActividadExterna(this.idActividad).subscribe(
                  (respuesta2) => {
                    if(respuesta2){
                    this.socios= respuesta2;
                    }
                  }
                )
                this.actividadesService.getMiembrosPorActividadExterna(this.idActividad).subscribe(
                  (respuesta2) => {
                    if(respuesta2){
                    this.miembros = respuesta2;
                    }
                  }
                )
                this.actividadesService.getPersonasPorActividadExterna(this.idActividad).subscribe(
                  (respuesta2) => {
                    if(respuesta2){
                    this.personas = respuesta2;
                    }
                  }
                )
                this.actividadesService.getAcompanantesPorActividadExterna(this.idActividad).subscribe(
                  (respuesta2) => {
                    if(respuesta2){
                    this.acompanantes = respuesta2;
                    }
                  }
                )
 
              }else{
              alert("No existe esa  actividad");
              this.router.navigate(["/actividades/listado"]);
              }
            }
          )
        }
      }
    )
  }

}
