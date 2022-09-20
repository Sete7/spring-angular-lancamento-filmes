import { FilmesService } from './../../core/filmes.service';
import { Component, OnInit } from '@angular/core';
import { Filmes } from 'src/app/shared/components/filmes/filmes';

@Component({
  selector: 'app-listagem-filmes',
  templateUrl: './listagem-filmes.component.html',
  styleUrls: ['./listagem-filmes.component.css']
})
export class ListagemFilmesComponent implements OnInit {

  filmes: Filmes[] = []; 

  constructor(private filmesService: FilmesService) { }

  ngOnInit(): void {
    this.filmesService.listar().subscribe(
      (filmes: Filmes[]) => {
        this.filmes = filmes.concat();
      }
    )
  }

}
