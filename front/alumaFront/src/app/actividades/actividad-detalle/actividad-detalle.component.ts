import { Participantes } from './../../modelo/Participantes';
import { ServiciosModule } from './../../servicios/servicios.module';
import { ActividadesService } from 'src/app/servicios/actividades.service';
import { Component, OnInit } from '@angular/core';
import { Externa } from 'src/app/modelo/Externa';
import { Local } from 'src/app/modelo/Local';

@Component({
  selector: 'app-actividad-detalle',
  templateUrl: './actividad-detalle.component.html',
  styleUrls: ['./actividad-detalle.component.css']
})
export class ActividadDetalleComponent implements OnInit {

  idActividad = 1;
  detalle;
  local: Local;
  externa: Externa;
  listaParticipantes: [];
  numeroParticipantes: number;

  constructor(private actividadesService:  ActividadesService) { }

  ngOnInit(): void {
    this.numeroParticipantes = 0;
    this.listaParticipantes = null;
    this.detalle = {
        nombre: null,
        fecha: null,
        numeroPlazas: null,
        precio: null,
        listaReserva: [],
        reservaPlazasEmpleados: null,
        destino: null
    }

    this.actividadesService.getActividadLocalPorId(this.idActividad).subscribe(
      (respuesta: Local) =>{
        if(respuesta){
          this.local = respuesta[0];
          this.localADetalle();
          this.actividadesService.getParticipantesActividadLocal(this.idActividad).subscribe(
            (respuesta2) => {
              this.listaParticipantes = respuesta2;
            }
          )
          console.log(this.listaParticipantes);
        }else{
          this.actividadesService.getActividadExternaPorId(this.idActividad).subscribe(
            (respuesta2: any) =>{
              if(respuesta2){
                this.externa = respuesta2[0];
                this.externaADetalle();
              }else{
              // this.router.navigate(["/actividades/form"]);
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

}
