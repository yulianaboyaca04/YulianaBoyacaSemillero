import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { GestionarComicComponent } from './semillero/componentes/gestionarComic/gestionar-comic';
import { BienvenidaComponent } from './semillero/componentes/home/bienvenida-component';
import { ConsultarComicComponent } from './semillero/componentes/consultarComic/consultar-comic.component';
import { GestionarUsuarioComponent } from './semillero/componentes/gestionarUsuario/gestionar-usuario-component';
import { ConsultarUsuarioComponent } from './semillero/componentes/consultarUsuario/consultar-usuario-component';

const routes: Routes = [
  { path: 'gestionar-comic', component: GestionarComicComponent },
  { path: 'gestionar-usuario', component: GestionarUsuarioComponent },
  { path: 'bienvenida', component: BienvenidaComponent, data : null },
  { path: 'consultar-comic', component: ConsultarComicComponent, data : null },
  { path: 'consultar-usuario', component: ConsultarUsuarioComponent, data : null } 
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
