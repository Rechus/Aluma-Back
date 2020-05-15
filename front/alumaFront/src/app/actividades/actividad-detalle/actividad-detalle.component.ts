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

  idActividad = 0;
  detalle;
  local: Local;
  externa: Externa;

  constructor(private actividadesService:  ActividadesService) { }

  ngOnInit(): void {

    this.detalle = {
        nombre: null,
        fecha: null,
        numeroPlazas: null,
        precio: null,
        listaParticipantes: [],
        listaReserva: [],
        reservaPlazasEmpleados: null,
        destino: null
    }

    this.actividadesService.getActividadLocalPorId(this.idActividad).subscribe(
      (respuesta: Local) =>{
        if(respuesta){
          this.local = respuesta[0];
          this.localADetalle();
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
    this.detalle.listaParticipantes = this.local.listaParticipantes;
    this.detalle.listaReserva = this.local.listaReserva;
    this.detalle.destino = "Actividad Local";
  }

  externaADetalle(){
    this.detalle.nombre = this.externa.nombre;
    this.detalle.fecha = this.externa.fecha;
    this.detalle.numeroPlazas = this.externa.numeroPlazas;
    this.detalle.precio = this.externa.precio;
    this.detalle.listaParticipantes = this.externa.listaParticipantes;
    this.detalle.listaReserva = this.externa.listaReserva;
    this.detalle.destino = this.externa.destino;
  }

}
