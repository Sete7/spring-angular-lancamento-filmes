import { tap } from 'rxjs/operators';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FilmesDto } from './../shared/components/filmes/filmes';


@Injectable({
  providedIn: 'root'
})
export class FilmesService {

  readonly apiURL : string = "http://localhost:8080/filmes";

  constructor(private http : HttpClient) { }

  listar(titulo: string, page:number, size:number): Observable<FilmesDto[]>{  
    return this.http.get<FilmesDto[]>(`${this.apiURL}/listarTitulo?titulo=${titulo}&page=${page}&size=${size}`)
    // .pipe(
    //   tap( resp => { console.log(resp)}));
  }
}
