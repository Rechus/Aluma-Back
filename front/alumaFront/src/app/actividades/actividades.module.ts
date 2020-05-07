import { RouterModule } from '@angular/router';
import { ComunModule } from './../comun/comun.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActividadesListaComponent } from './actividades-lista/actividades-lista.component';



@NgModule({
  declarations: [ActividadesListaComponent],
  imports: [
    CommonModule,
    ComunModule,
    RouterModule.forChild([
      {path: '', component: ActividadesListaComponent}

    ])
  ],
  exports: [ActividadesListaComponent]
})
export class ActividadesModule { }
 