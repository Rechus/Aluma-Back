import { NgForm } from '@angular/forms';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-actividad-form',
  templateUrl: './actividad-form.component.html',
  styleUrls: ['./actividad-form.component.css']
})
export class ActividadFormComponent implements OnInit {

  actividad;

  constructor() { }

  ngOnInit(): void {
    this.actividad = {
      nombre: null,
      timeStamp: null,
      numeroPlazas: null,
      precio: null,
      reservaPlazasEmpleados: null,
      numeroPlazasNoEmp: null,
      listaParticipantes: [],
      listaRerservas: [],
      destino: null
    }
  }

  guardar(f: NgForm){
    console.log(f);
  }

}
