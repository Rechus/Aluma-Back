import { ActividadExterna } from './../../modelo/actividadExterna';
import { Actividad } from './../../modelo/actividad';
import { ActividadesService } from 'src/app/servicios/actividades.service';
import { NgForm } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-actividad-form',
  templateUrl: './actividad-form.component.html',
  styleUrls: ['./actividad-form.component.css']
})
export class ActividadFormComponent implements OnInit {

  actividad: Actividad;
  actividadExterna: ActividadExterna;
  marked;
  theCheckbox = false;
  dateNow : Date = new Date();
  hoy : String = this.formateoFecha();
  
  constructor(private actividadesService: ActividadesService, private router: Router ) { 
    
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

  ngOnInit(): void {
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



