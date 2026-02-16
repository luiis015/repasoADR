import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AgregarComponent } from './components/agregar/agregar';
import { ListarComponent } from './components/listar/listar';

const routes: Routes = [
  { path: 'agregar', component: AgregarComponent },
  { path: 'listar', component: ListarComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 

}