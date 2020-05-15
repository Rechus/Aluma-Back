import { ActividadDetalleComponent } from './actividad-detalle/actividad-detalle.component';
import { RouterModule } from '@angular/router';
import { ComunModule } from './../comun/comun.module';
import { NgModule, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActividadesListaComponent } from './actividades-lista/actividades-lista.component';
import { ActividadHomeComponent } from './actividad-home/actividad-home.component';
import { ActividadFormComponent } from './actividad-form/actividad-form.component';



@NgModule({
  declarations: [ActividadesListaComponent, ActividadHomeComponent, ActividadFormComponent, ActividadDetalleComponent],
  imports: [
    CommonModule,
    ComunModule,
    RouterModule.forChild([
      {path: '', component: ActividadHomeComponent,
      children: [
      {path: 'listado', component: ActividadesListaComponent},
      {path: "form/:id", component: ActividadFormComponent},
      {path: 'form', component: ActividadFormComponent},
      {path: 'listado/detalle', component: ActividadDetalleComponent},
     
      ]
    }
    ])
  ],
  exports: [ActividadesListaComponent, ActividadDetalleComponent]
})
export class ActividadesModule { }
 