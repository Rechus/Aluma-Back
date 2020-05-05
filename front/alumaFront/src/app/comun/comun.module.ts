import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CabeceraComponent } from './cabecera/cabecera.component';
import { LateralComponent } from './lateral/lateral.component';
import { HomeComponent } from './home/home.component';
import { PieComponent } from './pie/pie.component';



@NgModule({
  declarations: [CabeceraComponent, LateralComponent, HomeComponent, PieComponent],
  imports: [
    CommonModule
  ]
})
export class ComunModule { }
