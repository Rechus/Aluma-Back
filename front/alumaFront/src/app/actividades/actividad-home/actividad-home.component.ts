import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-actividad-home',
  templateUrl: './actividad-home.component.html',
  styleUrls: ['./actividad-home.component.css']
})
export class ActividadHomeComponent implements OnInit {
  

  constructor(private router: Router) { }

  ngOnInit(): void {
    this.router.navigate(["/actividades/listado"]);
  }

}
