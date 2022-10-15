import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';

import { FilmesService } from './../../core/filmes.service';
import { FilmesDto } from 'src/app/shared/components/filmes/filmesDto';
import { Router } from '@angular/router';


@Component({
  selector: 'app-listagem-filmes',
  templateUrl: './listagem-filmes.component.html',
  styleUrls: ['./listagem-filmes.component.css']
})
export class ListagemFilmesComponent implements OnInit {

  readonly semFoto = 'assets/img/sem-foto.png';
  filmes: FilmesDto[];
  filme: FilmesDto;
  titulo = '';
  page = 0;
  size = 4;
  numberElements!: number;
  totalElements!: number;
  totalPages!: number;
  loading = false;
  btnNextDisabled!: boolean;
  btnPrevDisabled!: boolean;
  filtrosListagem: FormGroup;

  constructor(
    private fb: FormBuilder,
    private filmesService: FilmesService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.formulario();
    this.valueChangeTitulo();
    this.list(this.titulo, this.page, this.size);
  }

  formulario(): void {
    this.filtrosListagem = this.fb.group(
      { titulo: [null] }
    );
  }

  valueChangeTitulo(): void {
    this.filtrosListagem.get('titulo').valueChanges.subscribe(
      (resp: any) => {
        this.loading = false;
        this.titulo = resp;
        this.titulo = this.filtrosListagem.get('titulo')?.value;
        this.resetarConsulta();
      }
    );
  }

  list(titulo: string, page: number, size: number): void{
    this.filmesService.listar(titulo, page, size).subscribe(
      filmes => {
        this.loading = true;
        setTimeout(() => {
          const content = 'content';
          const numberOfElements = 'numberOfElements';
          const totalElements = 'totalElements';
          const totalPages = 'totalPages';
          this.filmes = filmes[content];
          this.numberElements = filmes[numberOfElements];
          this.totalElements = filmes[totalElements];
          this.totalPages = filmes[totalPages];
          this.paginatorControl();
          this.loading = false;
        }, 2500);
      }
    );
  }

  paginatorControl(): void {
    if (this.page <= 0) {
      this.btnPrevDisabled = true;
    } else {
      this.btnPrevDisabled = false;
    }

    if (this.numberElements < 4 || (this.totalElements % this.totalPages) === 0 && this.page === this.totalPages) {
      this.btnNextDisabled = true;
    } else {
      this.btnNextDisabled = false;
    }
  }

  prevPage(): void{
    this.page--;
    this.filme = new FilmesDto();
    this.filme.titulo = this.filtrosListagem.get('titulo')?.value;
    this.list(this.titulo, this.page, this.size);
  }

  nextPage(): void{
    this.page++;
    this.filme = new FilmesDto();
    this.filme.titulo = this.filtrosListagem.get('titulo')?.value;
    this.list(this.titulo, this.page, this.size);
  }

  private resetarConsulta(): void{
    this.page = 0;
    this.filmes = [];
    this.list(this.titulo, this.page, this.size);
  }

  abrir(id: number): void{
    this.router.navigateByUrl('/filmes/' + id);
  }
}






