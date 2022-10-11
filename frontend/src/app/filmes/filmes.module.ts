import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MaterialModule } from './../shared/material/material.module';

import { CadastroFilmesComponent } from './cadastro-filmes/cadastro-filmes.component';
import { ListagemFilmesComponent } from './listagem-filmes/listagem-filmes.component';
import { VisualizarFilmesComponent } from './visualizar-filmes/visualizar-filmes.component';
import { CampoModule } from './../shared/components/campo/campo.module';

@NgModule({
  declarations: [CadastroFilmesComponent, ListagemFilmesComponent, VisualizarFilmesComponent],
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    CampoModule
  ],
  exports: [
    CadastroFilmesComponent, ListagemFilmesComponent, VisualizarFilmesComponent
  ]
})
export class FilmesModule { }
