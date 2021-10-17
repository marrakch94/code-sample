import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {ForumView} from '../model/ForumView';
import {WordView} from '../model/WordView';

@Injectable({
  providedIn: 'root'
})
export class WordService {
  baseUrl = 'http://localhost:8082/word';
  constructor(private http: HttpClient) { }

  getN(nbrWord:number):Observable<WordView[]> {
    return this.http.get<WordView[]>(`${this.baseUrl}/${nbrWord}`);
  }
}
