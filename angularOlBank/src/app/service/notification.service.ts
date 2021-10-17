import { Injectable } from '@angular/core';

import { Subject } from 'rxjs';
import { WebSocketService } from './web-socket.service';
import { HttpClient } from '@angular/common/http';
import { NotificationDef } from '../model/NotificationDef';
import { Message } from '../model/Message';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {
  tokens = [
    'eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJlbCB3ZXNzIDIiLCJleHAiOjE2MjcyMjYwMzEsImlhdCI6MTYyNjYyMTIzMX0.931c7K_rCBZj_SRrRWRAWKLdvTVm0mDMxgr9SESZJ68GnVNBPLAlE6YmyU0wbD0CXL5UuPpcFZx7QPp4WckwXg'
  ]

  notificationSubject = new Subject<any>();
  notifications$ = this.notificationSubject.asObservable();
  baseUrl = 'http://localhost:8082/notification';

  constructor(private webSocketService: WebSocketService,
    private http: HttpClient) { }

  listen() {
    this.webSocketService.connect(this.tokens[0]);
    this.webSocketService.isConnected.subscribe(bool => {
      if (bool) {
        this.webSocketService.client.subscribe('/user/notifications', (notification) => {
          this.notificationSubject.next(notification);
        });
      }
    })
    return this.notifications$;
  }



  save(notif: NotificationDef) {
    return this.http.post(this.baseUrl, notif);
  }

  delete(notif: NotificationDef) {
    return this.http.delete(`${this.baseUrl}/${notif.id}`);
  }

  update(notif: NotificationDef) {
    return this.http.put(`${this.baseUrl}`, notif);
  }

  getAll() {
    return this.http.get<NotificationDef[]>(this.baseUrl);
  }

  getOne(id: number) {
    return this.http.get<NotificationDef>(`${this.baseUrl}/${id}`)
  }
}
