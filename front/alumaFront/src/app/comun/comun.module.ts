import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CabeceraComponent } from './cabecera/cabecera.component';
import { LateralComponent } from './lateral/lateral.component';
import { HomeComponent } from './home/home.component';
import { PieComponent } from './pie/pie.component';
import { ServiciosModule} from './../servicios/servicios.module';
import { MatIconModule} from '@angular/material/icon';
import { MatInputModule} from '@angular/material/input';
import { MatFormFieldModule} from '@angular/material/form-field';


@NgModule({
  declarations: [CabeceraComponent, LateralComponent, HomeComponent, PieComponent],
  imports: [
    CommonModule,
    ServiciosModule,
    MatIconModule,
    MatInputModule,
    MatFormFieldModule,
    RouterModule
  ],
  exports:  [
    CabeceraComponent,
    LateralComponent, 
    HomeComponent, 
    PieComponent,
    MatIconModule,
    MatInputModule,
    MatFormFieldModule
  ]
})
export class ComunModule { }
