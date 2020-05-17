import { Participantes } from './../../modelo/Participantes';
import { ServiciosModule } from './../../servicios/servicios.module';
import { ActividadesService } from 'src/app/servicios/actividades.service';
import { Component, OnInit } from '@angular/core';
import { Externa } from 'src/app/modelo/Externa';
import { Local } from 'src/app/modelo/Local';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-actividad-detalle',
  templateUrl: './actividad-detalle.component.html',
  styleUrls: ['./actividad-detalle.component.css']
})
export class ActividadDetalleComponent implements OnInit {

  idActividad;
  detalle;
  local: Local;
  externa: Externa;
  listaParticipantes: [];
  numeroParticipantes: number;
  numeroReservas: number;


  constructor(private actividadesService:  ActividadesService,
    private ruta: ActivatedRoute,
    private  router: Router) { }

  ngOnInit(): void {
    this.idActividad = this.ruta.snapshot.paramMap.get('id');
    this.numeroParticipantes = 0;
    this.listaParticipantes = null;
    this.detalle = {
        nombre: null,
        fecha: null,
        numeroPlazas: null,
        precio: null,
        reservaPlazasEmpleados: null,
        destino: null
    }

    this.actividadesService.getActividadLocalPorId(this.idActividad).subscribe(
      (respuesta: Local) =>{
        if(respuesta){
          this.local = respuesta[0];
          this.localADetalle();
          this.actividadesService.getSociosPorActividadLocal(this.idActividad).subscribe(
            (respuesta2) => {
              if(respuesta2){
              this.listaParticipantes = respuesta2;
              this.numeroParticipantes = this.listaParticipantes.length;
              }
            }
          )
          this.actividadesService.getMiembrosPorActividadLocal(this.idActividad).subscribe(
            (respuesta2) => {
              if(respuesta2){
              this.listaParticipantes = respuesta2;
              this.numeroParticipantes += this.listaParticipantes.length;
              }
            }
          )
          this.actividadesService.getPersonasPorActividadLocal(this.idActividad).subscribe(
            (respuesta2) => {
              if(respuesta2){
              this.listaParticipantes = respuesta2;
              this.numeroParticipantes += this.listaParticipantes.length;
              }
            }
          )
          this.actividadesService.getAcompanantesPorActividadLocal(this.idActividad).subscribe(
            (respuesta2) => {
              if(respuesta2){
              this.listaParticipantes = respuesta2;
              this.numeroParticipantes += this.listaParticipantes.length;
              }
            }
          )
          this.actividadesService.getReservasPorActividadLocal(this.idActividad).subscribe(
            (respuesta2) => {
              this.numeroReservas = respuesta2.length;
            }
          )
          
        }else{
          this.actividadesService.getActividadExternaPorId(this.idActividad).subscribe(
            (respuesta: Externa) =>{
              if(respuesta){
                this.externa = respuesta[0];
                this.externaADetalle();
                this.actividadesService.getSociosPorActividadExterna(this.idActividad).subscribe(
                  (respuesta2) => {
                    if(respuesta2){
                    this.listaParticipantes = respuesta2;
                    this.numeroParticipantes = this.listaParticipantes.length;
                    }
                  }
                )
                this.actividadesService.getMiembrosPorActividadExterna(this.idActividad).subscribe(
                  (respuesta2) => {
                    if(respuesta2){
                    this.listaParticipantes = respuesta2;
                    this.numeroParticipantes += this.listaParticipantes.length;
                    }
                  }
                )
                this.actividadesService.getPersonasPorActividadExterna(this.idActividad).subscribe(
                  (respuesta2) => {
                    if(respuesta2){
                    this.listaParticipantes = respuesta2;
                    this.numeroParticipantes += this.listaParticipantes.length;
                    }
                  }
                )
                this.actividadesService.getAcompanantesPorActividadExterna(this.idActividad).subscribe(
                  (respuesta2) => {
                    if(respuesta2){
                    this.listaParticipantes = respuesta2;
                    this.numeroParticipantes += this.listaParticipantes.length;
                    }
                  }
                )
                this.actividadesService.getReservasPorActividadExterna(this.idActividad).subscribe(
                  (respuesta2) => {
                    this.numeroReservas = respuesta2.length;
                  }
                )
              }else{
              alert("No se ha encontrado ninguna actividad");
              this.router.navigate(["/actividades/form"]);
              }
            }
          )
        }
      }
    )
  }

  localADetalle(){
    this.detalle.nombre = this.local.nombre;
    this.detalle.fecha = this.local.fecha;
    this.detalle.numeroPlazas = this.local.numeroPlazas;
    this.detalle.precio = this.local.precio;
    this.detalle.reservaPlazasEmpleados = this.local.reservaPlazasEmpleados;
    this.detalle.destino = "Actividad Local";
  }

  externaADetalle(){
    this.detalle.nombre = this.externa.nombre;
    this.detalle.fecha = this.externa.fecha;
    this.detalle.numeroPlazas = this.externa.numeroPlazas;
    this.detalle.precio = this.externa.precio;
    this.detalle.reservaPlazasEmpleados = this.externa.reservaPlazasEmpleados;
    this.detalle.destino = this.externa.destino;
  }

  borrarActividad(){
    if (confirm("¿Desea borrar la actividad?")){
      if(this.detalle.destino == "Actividad Local"){
        this.actividadesService.borrarActividadLocal(this.idActividad).subscribe(
          () => this.router.navigate(["/actividades/listado"])
        )
      }else{
        this.actividadesService.borrarActividadExterna(this.idActividad).subscribe(
          () => this.router.navigate(["/actividades/listado"])
        )
      }
    }

  }

}
