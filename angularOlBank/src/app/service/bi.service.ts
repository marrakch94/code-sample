import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BiView} from '../model/BiView';
import {Stat} from '../model/Stat';

@Injectable({
  providedIn: 'root'
})
export class BiService {
  baseUrl = 'http://localhost:8082/bi';

  constructor(private http: HttpClient) {
  }

  getByYear(year:number) {
    return this.http.get<BiView[]>(`${this.baseUrl}/${year}`);
  }

  getStat() {
    return this.http.get<Stat>(`${this.baseUrl}/stat`);
  }
}
