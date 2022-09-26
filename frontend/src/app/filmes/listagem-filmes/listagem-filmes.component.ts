import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Observable } from 'rxjs';
import { FilmesService } from './../../core/filmes.service';
import { FilmesDto } from 'src/app/shared/components/filmes/filmes';

@Component({
  selector: 'app-listagem-filmes',
  templateUrl: './listagem-filmes.component.html',
  styleUrls: ['./listagem-filmes.component.css']
})
export class ListagemFilmesComponent implements OnInit {

  filmes: FilmesDto[];
  filme: FilmesDto;
  titulo: string = '';
  genero: string;
  page: number = 0;
  size: number = 4;
  numberElements!: number;
  totalElements!: number;
  totalPages!: number;

  btnNextDisabled!: boolean;
  btnPrevDisabled!: boolean;
  generos: Array<string>;

  filtrosListagem: FormGroup;
  content$: Observable<any>;

  constructor(
    private fb: FormBuilder,
    private filmesService: FilmesService
  ) { }

  ngOnInit(): void {
    this.formulario();

    this.filtrosListagem.get('titulo').valueChanges.subscribe(
      (resp: string) => {
        this.titulo = resp;
        this.titulo = this.filtrosListagem.get('titulo')?.value
        this.resetarConsulta();
      }
    )

    this.filtrosListagem.get('genero').valueChanges.subscribe(
      (resp: string) => {
        this.genero = resp;
        console.log(this.genero)
      }
    )

    this.generos = ['Ação', 'Romance', 'Aventura', 'Terror', 'Ficção cientifica', 'Comédia', 'Aventura', 'Drama'];
    this.list(this.titulo, this.page, this.size);
  }

  formulario() {
    this.filtrosListagem = this.fb.group(
      {
        titulo: [null],
        genero: [null]
      })
  }

  list(titulo: string, page: number, size: number): void {
    this.titulo != '';
    this.filmesService.listar(titulo, page, size).subscribe(
      filmes => {
        console.log(filmes)
        this.filmes = filmes['content'];
        this.numberElements = filmes['numberOfElements'];
        this.totalElements = filmes['totalElements'];
        this.totalPages = filmes['totalPages'];
        this.paginatorControl();
      }
    )
  }


  paginatorControl() {
    if (this.page <= 0) {
      this.btnPrevDisabled = true;
    } else {
      this.btnPrevDisabled = false;
    }

    if (this.numberElements < 4 ||
      (this.totalElements % this.totalPages) == 0 &&
      this.page == this.totalPages) {
      this.btnNextDisabled = true;
    } else {
      this.btnNextDisabled = false;
    }
  }

  prevPage() {
    this.page--;
    this.filme = new FilmesDto();
    this.filme.titulo = this.filtrosListagem.get('titulo')?.value;
    this.list(this.titulo, this.page, this.size);
  }

  nextPage() {
    this.page++;
    this.filme = new FilmesDto();
    this.filme.titulo = this.filtrosListagem.get('titulo')?.value;
    this.list(this.titulo, this.page, this.size);
  }

  private resetarConsulta(): void {
    this.page = 0;
    this.filmes = [];
    this.list(this.titulo, this.page, this.size);
  }

}