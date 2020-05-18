import { element } from 'protractor';
import { Component, OnInit } from '@angular/core';
import { Local } from 'src/app/modelo/Local';
import { Externa } from 'src/app/modelo/Externa';
import { ActividadesService } from 'src/app/servicios/actividades.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-actividad-reservas',
  templateUrl: './actividad-reservas.component.html',
  styleUrls: ['./actividad-reservas.component.css']
})
export class ActividadReservasComponent implements OnInit {

  nombre = "";
  idActividad;
  detalle;
  local: Local;
  externa: Externa;
  reservas;
  constructor(private actividadesService:  ActividadesService,
    private ruta: ActivatedRoute,
    private  router: Router) { }

  ngOnInit(): void {
    this.reservas = [];
    this.idActividad = this.ruta.snapshot.paramMap.get('id');
    this.actividadesService.getActividadLocalPorId(this.idActividad).subscribe(
      (respuesta: Local) =>{
        if(respuesta){
          this.local = respuesta[0];
          this.nombre = this.local.nombre;
          this.actividadesService.getReservasPorActividadLocal(this.idActividad).subscribe(
            (respuesta2) => this.reservas = respuesta2);
    }else{
      this.actividadesService.getActividadExternaPorId(this.idActividad).subscribe(
        (respuesta: Externa) =>{
          if(respuesta){
            this.externa = respuesta[0];
            this.nombre = this.externa.nombre;
            this.actividadesService.getReservasPorActividadExterna(this.idActividad).subscribe(
              (respuesta2) => this.reservas = respuesta2);
          }else{
             alert("No existe esa actividad");
            this.router.navigate(["/actividades/listado"]);
           }
         }
       )
     }
   }
  )
}

}

