import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Forum} from '../model/Forum';
import {Observable} from 'rxjs';
import {ForumView} from '../model/ForumView';
import {ForumMatch} from '../model/ForumMatch';

@Injectable({
  providedIn: 'root'
})
export class ForumService {
  baseUrl = 'http://localhost:8082/forum';

  constructor(private http: HttpClient) {
  }

    getAll() {
        return this.http.get(`${this.baseUrl}`);
    }

    getRecap():Observable<ForumView[]> {
        return this.http.get<ForumView[]>(`${this.baseUrl}/recap`);
    }

    getAllSub(): Observable<Forum[]> {
        return this.http.get<Forum[]>(`${this.baseUrl}`);
    }

    getByForumId(forumId: number): Observable<Forum> {
        return this.http.get<Forum>(`${this.baseUrl}/${forumId}`);
    }

    getMatch(topic:string): Observable<ForumMatch[]> {
        return this.http.get<ForumMatch[]>(`${this.baseUrl}/topich/${topic}`)
    }

    Save(forum:Forum) {
      return this.http.post(`${this.baseUrl}/`, forum)
    }
    /*
    getAll() {
        return this.http.get(Context.apiUrl+'forum');
    }
    getAllSub(): Observable<Forum[]> {
        return this.http.get<Forum[]>(Context.apiUrl+'forum');
    }

    getByForumId(forumId:number):Observable<Forum> {
        return this.http.get<Forum>(Context.apiUrl+'forum'+forumId);
    }*/
}
