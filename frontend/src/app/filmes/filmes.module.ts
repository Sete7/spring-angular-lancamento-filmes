import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from './../shared/material/material.module';

import { CadastroFilmesComponent } from './cadastro-filmes/cadastro-filmes.component';
import { ListagemFilmesComponent } from './listagem-filmes/listagem-filmes.component';
import { VisualizarFilmesComponent } from './visualizar-filmes/visualizar-filmes.component';

@NgModule({
  declarations: [CadastroFilmesComponent, ListagemFilmesComponent, VisualizarFilmesComponent],
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule, 
    ReactiveFormsModule
  ],
  exports: [
    CadastroFilmesComponent, ListagemFilmesComponent, VisualizarFilmesComponent
  ]
})
export class FilmesModule { }
