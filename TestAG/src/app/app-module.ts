import { NgModule, provideBrowserGlobalErrorListeners } from '@angular/core';
import { BrowserModule, provideClientHydration, withEventReplay } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing-module';
import { App } from './app';
import { FormsModule } from '@angular/forms';
import { AgregarComponent } from './components/agregar/agregar';
import { AppComponent } from './components/app-component/app-component';
import { CatalogoComponent } from './components/catalogo/catalogo';
import { HomeComponent } from './components/home/home';
import { ListarComponent } from './components/listar/listar';


@NgModule({
  declarations: [
    App,
    AgregarComponent,
    AppComponent,
    CatalogoComponent,
    HomeComponent,
    ListarComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideClientHydration(withEventReplay()),
  ],
  bootstrap: [App]
})
export class AppModule { }
