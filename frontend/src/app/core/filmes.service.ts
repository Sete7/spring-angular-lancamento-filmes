import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { EMPTY, Observable } from 'rxjs';
import { tap, catchError, map } from 'rxjs/operators';
import { FilmesDto } from './../shared/components/filmes/filmes';
import { MatSnackBar } from '@angular/material/snack-bar';


@Injectable({
  providedIn: 'root'
})
export class FilmesService {

  readonly apiURL: string = "http://localhost:8080/filmes";

  constructor(
    private snackBar: MatSnackBar,
    private http: HttpClient
  ) { }

  listar(titulo: string, page: number, size: number): Observable<FilmesDto[]> {
    return this.http.get<FilmesDto[]>(`${this.apiURL}/listarTitulo?titulo=${titulo}&page=${page}&size=${size}`)
      .pipe(
        tap(resp => { console.log(resp) }),
        map((obj)=> obj),
        catchError((e) => this.errorHandler(e))
        );
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

  errorHandler(e:any): Observable<any> {
    this.showMessage("Ocorreu algum error! ", true);
    return EMPTY;
  }
}
