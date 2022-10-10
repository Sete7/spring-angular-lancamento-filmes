import { Filmes } from './../../shared/components/filmes/filmes';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FilmesService } from './../../core/filmes.service';

@Component({
  selector: 'app-visualizar-filmes',
  templateUrl: './visualizar-filmes.component.html',
  styleUrls: ['./visualizar-filmes.component.css']
})
export class VisualizarFilmesComponent implements OnInit {

  filme: Filmes;
  id: number;

  constructor(
    private activatedRoute: ActivatedRoute,
    private filmesService: FilmesService
  ) { }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['id'];
    this.filmesService.buscaPorId(this.id).subscribe(
      (filme: Filmes) => {
        this.filme = filme;
      }
    )
  }

  editar(): void {

  }

  excluir(): void {

  }

}
