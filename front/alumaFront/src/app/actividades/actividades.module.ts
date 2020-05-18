import { ActividadDetalleComponent } from './actividad-detalle/actividad-detalle.component';
import { RouterModule } from '@angular/router';
import { ComunModule } from './../comun/comun.module';
import { NgModule, Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActividadesListaComponent } from './actividades-lista/actividades-lista.component';
import { ActividadHomeComponent } from './actividad-home/actividad-home.component';
import { ActividadFormComponent } from './actividad-form/actividad-form.component';
import { ActividadParticipantesComponent } from './actividad-participantes/actividad-participantes.component';
import { ActividadReservasComponent } from './actividad-reservas/actividad-reservas.component';



@NgModule({
  declarations: [ActividadesListaComponent, ActividadHomeComponent, ActividadFormComponent, ActividadDetalleComponent, ActividadParticipantesComponent, ActividadReservasComponent],
  imports: [
    CommonModule,
    ComunModule,
    RouterModule.forChild([
      {path: '', component: ActividadHomeComponent,
      children: [
      {path: 'listado', component: ActividadesListaComponent},
      {path: "form/:id", component: ActividadFormComponent},
      {path: 'form', component: ActividadFormComponent},
      {path: ':id/participantes', component: ActividadParticipantesComponent},
      {path: ':id/reservas', component: ActividadReservasComponent},
      {path: ':id', component: ActividadDetalleComponent},
      ]
    }
    ])
  ],
  exports: [ActividadesListaComponent, ActividadDetalleComponent, ActividadesListaComponent]
})
export class ActividadesModule { }
 