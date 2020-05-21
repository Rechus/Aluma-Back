import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CabeceraComponent } from './cabecera/cabecera.component';
import { LateralComponent } from './lateral/lateral.component';
import { HomeComponent } from './home/home.component';
import { PieComponent } from './pie/pie.component';
import { ServiciosModule} from './../servicios/servicios.module';




@NgModule({
  declarations: [CabeceraComponent, LateralComponent, HomeComponent, PieComponent],
  imports: [
    CommonModule,
    ServiciosModule,
    FormsModule,
    RouterModule
  ],
  exports:  [
    CabeceraComponent,
    LateralComponent, 
    HomeComponent, 
    PieComponent,
    FormsModule
  ]
})
export class ComunModule { }
