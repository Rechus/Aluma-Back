import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CabeceraComponent } from './comun/cabecera/cabecera.component';
import { LateralComponent } from './comun/lateral/lateral.component';
import { PieComponent } from './comun/pie/pie.component';
import { HomeComponent } from './comun/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    CabeceraComponent,
    LateralComponent,
    PieComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
