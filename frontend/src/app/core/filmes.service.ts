import { Filmes } from './../shared/components/filmes/filmes';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FilmesService {

  readonly apiURL : string = "http://localhost:8080/filmes";

  constructor(private http : HttpClient) { }

  listar(): Observable<Filmes[]>{
    return this.http.get<Filmes[]>(this.apiURL);
  }
}
