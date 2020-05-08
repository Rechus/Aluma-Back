import { ActividadesOffService } from './servicios/actividades-off.service';
import { ComunModule } from './comun/comun.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ActividadesModule } from './actividades/actividades.module';

import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatSidenavModule} from '@angular/material/sidenav';
import { ActividadesService } from './servicios/actividades.service';
import { RouterModule } from '@angular/router';
import { HomeComponent } from './comun/home/home.component';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
  ],
  imports: [
    BrowserModule,
    ComunModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    FormsModule,
    RouterModule.forRoot([
      {path: '', component: HomeComponent},
      {path: 'actividades', loadChildren: './actividades/actividades.module#ActividadesModule'}
    ])
  ],
  providers: [
    { provide: ActividadesService, useClass: ActividadesOffService}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
