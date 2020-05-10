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
      date: null,
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

  fechaHoraToTimeStamp(fecha: Date) {
    let milisHora = new Date('1970-01-01T' + "00:00"  + 'Z').getTime();
    let fechaSinHora=  new Date(fecha.getFullYear(), fecha.getMonth(), fecha.getDate());
    return fechaSinHora.getTime() + milisHora;
  }


  guardar(f: NgForm) {
    console.log(f);
    this.actividad.date = this.fechaHoraToTimeStamp(this.actividad.date);
    this.actividadesService.crearActividad(this.actividad);
  }

  toggleVisibility(e){
    this.marked= e.target.checked;
  }

}



