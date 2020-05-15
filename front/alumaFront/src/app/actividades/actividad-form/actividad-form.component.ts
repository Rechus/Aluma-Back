
import { ActividadesService } from 'src/app/servicios/actividades.service';
import { NgForm } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Local } from 'src/app/modelo/Local';
import { Externa } from 'src/app/modelo/Externa';
import { Actividades } from 'src/app/modelo/Actividades';


@Component({
  selector: 'app-actividad-form',
  templateUrl: './actividad-form.component.html',
  styleUrls: ['./actividad-form.component.css']
})
export class ActividadFormComponent implements OnInit {

  actividad: Local;
  actividadExterna: Externa;
  marked;
  theCheckbox = false;
  dateNow : Date = new Date();
  hoy : String = this.formateoFecha(this.dateNow);
  titulo: string;
  fechaSinVisual: Date;
  fechaVisual: String;
  
  constructor(private actividadesService: ActividadesService,
     private router: Router, 
     private ruta: ActivatedRoute ) { 
    
  }


  ngOnInit(): void {

    let id = this.ruta.snapshot.paramMap.get('id');
    this.inicializarLocal();
    this.inicializarExterna();
    this.fechaVisual = "";
    
    if(id){
      this.actividadesService.getActividadLocalPorId(id).subscribe(
        (respuesta: Local) =>{
          if(respuesta){
            this.titulo = "Editar actividad";
            this.actividad = respuesta[0];
            this.fechaSinVisual = new Date(this.actividad.fecha);
            this.fechaVisual = this.formateoFecha(this.fechaSinVisual);
            console.log(this.fechaVisual);
          }else{
            this.actividadesService.getActividadExternaPorId(id).subscribe(
              (respuesta2: any) =>{
                if(respuesta2){
                  this.titulo = "Editar actividad";
                  this.marked = true;
                  this.actividadExterna = respuesta2[0];
                  this.pasoExternaLocal();
                  this.fechaSinVisual = new Date(this.actividad.fecha);
                  this.fechaVisual = this.formateoFecha(this.fechaSinVisual);
                  console.log(this.fechaVisual);
                }else{
                  this.router.navigate(["/actividades/form"]);
                }
              }
            )
          }
        }
      )
    } else {
      this.titulo = "Nueva actividad";
      this.marked = false;
    }
  }

   formateoFecha(fecha: Date){
    var cadena = "";
    var ano = fecha.getFullYear();
    var mes;
     if (fecha.getMonth() < 10){
       mes = "0"+(fecha.getMonth()+1);
     }else{
       mes = (fecha.getMonth()+1);
     }
    var dia;
    if (fecha.getDate() < 10){
     dia = "0"+fecha.getDate();
   }else{
     dia = fecha.getDate();
   }
   cadena = ano+"-"+mes+"-"+dia;
   return cadena;
   }


  guardar(f: NgForm) {
    console.log(this.actividadExterna);
    console.log(this.actividad);
    let id = this.ruta.snapshot.paramMap.get('id');
    if(id) {
      if(this.marked){
        this.actividadesService.modificarActividad(id, this.actividadExterna);
        }else{
          this.actividadesService.modificarActividad(id, this.actividad);
       }
    }else{
    if(this.marked){
      this.pasoLocalExterna();
      this.actividadesService.crearActividad(this.actividadExterna);
    }else{
      this.actividadesService.crearActividad(this.actividad);
    }
    this.router.navigate(["/actividades/listado"]);
  }
}

  comprobarExterna(){
    return this.marked;
  }

  inicializarLocal(){
    this.actividad = {
      nombre: null,
      fecha: null,
      numeroPlazas: null,
      precio: null,
      listaParticipantes: [],
      listaReserva: [],
      reservaPlazasEmpleados: null,
    }
  }

  inicializarExterna(){
    this.actividadExterna = {
      nombre: null,
      fecha: null,
      numeroPlazas: null,
      precio: null,
      listaParticipantes: [],
      listaReserva: [],
      reservaPlazasEmpleados: null,
      destino: null
    } 
  }

  pasoLocalExterna(){
    this.actividadExterna.nombre = this.actividad.nombre;
    this.actividadExterna.fecha = this.actividad.fecha;
    this.actividadExterna.numeroPlazas = this.actividad.numeroPlazas;
    this.actividadExterna.precio = this.actividad.precio;
    this.actividadExterna.reservaPlazasEmpleados = this.actividad.reservaPlazasEmpleados;
  }

  pasoExternaLocal(){
    this.actividad.nombre = this.actividadExterna.nombre;
    this.actividad.fecha = this.actividadExterna.fecha;
    this.actividad.numeroPlazas = this.actividadExterna.numeroPlazas;
    this.actividad.precio = this.actividadExterna.precio;
    this.actividad.reservaPlazasEmpleados = this.actividadExterna.reservaPlazasEmpleados;
  }

  toggleVisibility(e){
    this.marked= e.target.checked;
  }

  cancelar(f: NgForm){
    if (f.dirty){
    if(confirm("Las modificaciones se perderán. ¿Está seguro?")==false){
      return;
      }
    }
    this.router.navigate(["/actividades"]);
  }
}



