import { Injectable } from '@angular/core';
import * as StompJs from '@stomp/stompjs';
import * as SockJS from 'sockjs-client';
import { BehaviorSubject } from 'rxjs'
//'/src/app/app.constants';

@Injectable({
  providedIn: 'root'
})
export class WebSocketService {

  client: StompJs.Client;
  isConnected = new BehaviorSubject<boolean>(false);

  constructor() { }

  connect(token: string) {
    if (this.isConnected) {
      this.client = new StompJs.Client({
        brokerURL: 'ws://localhost:8082/ws',
        connectHeaders: {
          Authorization: token
        },
        debug: function (str) {
          console.log(str);
        },
        reconnectDelay: 5000,
        heartbeatIncoming: 4000,
        heartbeatOutgoing: 4000,
      });
      this.client.webSocketFactory = function () {
        // Note that the URL is different from the WebSocket URL
        return new SockJS('http://localhost:8082/ws');
      };
    }
    
    if (!this.isConnected.getValue()) {
      this.client.activate();
    }

    this.client.onConnect = (frame) => {
      this.isConnected.next(true);
    }

    this.client.onDisconnect = frame => {
      this.isConnected.next(false);
    }
  }

  close() {
    this.isConnected.next(false);
    this.client.deactivate();
  }

}
