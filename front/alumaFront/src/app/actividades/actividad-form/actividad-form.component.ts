
import { ActividadesService } from 'src/app/servicios/actividades.service';
import { NgForm } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { Local } from 'src/app/modelo/Local';
import { Externa } from 'src/app/modelo/Externa';


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
  hoy : String = this.formateoFecha();
  
  constructor(private actividadesService: ActividadesService,
     private router: Router, 
     private ruta: ActivatedRoute ) { 
    
  }


  ngOnInit(): void {
    let nombre = this.ruta.snapshot.paramMap.get("nombre");

    if(nombre){
      this.actividad = this.actividadesService.getActividadesConNombre(nombre);
    }else{

    this.actividad = {
      nombre: null,
      fecha: null,
      numeroPlazas: null,
      precio: null,
      listaParticipantes: [],
      listaReserva: [],
      reservaPlazasEmpleados: null,
    }
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
    this.marked = false;
  }
  }


  formateoFecha(){
    var cadena = "";
    var ano = this.dateNow.getFullYear();
    var mes;
     if (this.dateNow.getMonth() < 10){
       mes = "0"+(this.dateNow.getMonth()+1);
     }else{
       mes = (this.dateNow.getMonth()+1);
     }
    var dia;
    if (this.dateNow.getDate() < 10){
     dia = "0"+this.dateNow.getDate();
   }else{
     dia = this.dateNow.getDate();
   }
   cadena = ano+"-"+mes+"-"+dia;
   return cadena;
   }

  guardar(f: NgForm) {
    console.log(this.actividadExterna);
    console.log(this.actividad);
    if(this.marked){
      this.pasoLocalExterna();
      this.actividadesService.crearActividad(this.actividadExterna);
    }else{
      this.actividadesService.crearActividad(this.actividad);
    }
    this.router.navigate(["/actividades/listado"]);
  }

  comprobarExterna(){
    return this.marked;
  }

  pasoLocalExterna(){
    this.actividadExterna.nombre = this.actividad.nombre;
    this.actividadExterna.fecha = this.actividad.fecha;
    this.actividadExterna.numeroPlazas = this.actividad.numeroPlazas;
    this.actividadExterna.precio = this.actividad.precio;
    this.actividadExterna.reservaPlazasEmpleados = this.actividad.reservaPlazasEmpleados;
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



