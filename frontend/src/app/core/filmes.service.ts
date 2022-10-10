import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { EMPTY, Observable } from 'rxjs';
import { catchError, map } from 'rxjs/operators';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Filmes } from './../shared/components/filmes/filmes';
import { FilmesDto } from './../shared/components/filmes/filmesDto';

@Injectable({
  providedIn: 'root'
})
export class FilmesService {

  readonly apiURL: string = "http://localhost:8080/filmes";

  constructor(
    private snackBar: MatSnackBar,
    private http: HttpClient
  ) { }

  create(filmes: Filmes): Observable<Filmes> {
    return this.http.post<Filmes>(this.apiURL, filmes)
      .pipe(
        map((obj) => obj),
        catchError((e) => this.errorHandler(e))
      )
  }

  listar(titulo: string, page: number, size: number): Observable<FilmesDto[]> {
    return this.http.get<FilmesDto[]>(`${this.apiURL}/listarTitulo?titulo=${titulo}&page=${page}&size=${size}`)
      .pipe(
        map((obj) => obj),
        catchError((e) => this.errorHandler(e))
      )
  }

  buscaPorId(id: number): Observable<Filmes> {
    return this.http.get<Filmes>(`${this.apiURL}/` + id)
      .pipe(
        map((obj) => obj),
        catchError((e) => this.errorHandler(e))
      )
  }

  editar(filme: Filmes): Observable<Filmes> {
    return this.http.put<Filmes>(`${this.apiURL}/` + filme.id, filme)
      .pipe(
        map((obj) => obj),
        catchError((e) => this.errorHandler(e))
      )
  }

  excluir(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiURL}/` + id)
      .pipe(
        map((obj) => obj),
        catchError((e) => this.errorHandler(e)));
  }

  showMessage(msg: string, isError: boolean = false): void {
    this.snackBar.open(msg, "X", {
      duration: 3000,
      horizontalPosition: "right",
      verticalPosition: "top",
      panelClass: isError ? ['msg-error'] : ['msg-sucesso']
    }
    )
  }

  errorHandler(e: any): Observable<any> {
    this.showMessage("Ocorreu algum error! ", true);
    return EMPTY;
  }
}
