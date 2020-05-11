import { ActividadesService } from 'src/app/servicios/actividades.service';
import { NgForm } from '@angular/forms';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-actividad-form',
  templateUrl: './actividad-form.component.html',
  styleUrls: ['./actividad-form.component.css']
})
export class ActividadFormComponent implements OnInit {

  actividad;
  marked;
  theCheckbox = false;
  dateNow : Date = new Date();
  hoy : String = this.formateoFecha();
  
  constructor(private actividadesService: ActividadesService) { 
    
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
      reservaPlazasEmpleados: null,
      numeroPlazasNoEmp: null,
      listaParticipantes: [],
      listaRerservas: [],
      destino: null
    }
    this.marked = false;
  }




  guardar(f: NgForm) {
    console.log(f);
    console.log(this.actividad.fecha);
    this.actividadesService.crearActividad(this.actividad);
  }

  toggleVisibility(e){
    this.marked= e.target.checked;
  }

}



