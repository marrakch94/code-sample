import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Message } from '../model/Message';
import { MessageView } from '../model/MessageView';
import { Stat } from '../model/Stat';
import { WebSocketService } from './web-socket.service';
import { Subject } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class MessageService {
    baseUrl = 'http://localhost:8082/message';
    topic = '/topic/';

    private messageSubject = new Subject();
    message$ = this.messageSubject.asObservable();

    constructor(private http: HttpClient, private webSocketService: WebSocketService) {
    }

    listen(forumId) {
        this.webSocketService.isConnected.subscribe(bool => {
            if (bool) {
                this.webSocketService.client.subscribe(this.topic + forumId, (sdkEvent) => {
                    this.messageSubject.next(sdkEvent.body);
                });
            }
        })
        return this.message$;
    }

    send(message: Message) {
        console.log("calling logout api via web socket", this.webSocketService.client);
        this.webSocketService.client.publish({ destination: `/app/incomingmsg/${message.forum.forumId}`, body: JSON.stringify(message) });
    }

    delete(message: Message) {
        this.webSocketService.client.publish({ destination: `/app/deleteMsg/${message.forum.forumId}`, body: JSON.stringify(message) });
    }

    getAll() {
        return this.http.get(`${this.baseUrl}`);
    }

    getByForumId(forumId: number) {
        return this.http.get<Message[]>(`${this.baseUrl}/${forumId}`);
    }

    getAllMsgView() {
        return this.http.get<MessageView[]>(`${this.baseUrl}/msgView`);
    }

    getStat() {
        return this.http.get<Stat>(`${this.baseUrl}/stat`);
    }

    save(message: Message) {
        return this.http.post(`${this.baseUrl}/`, message)
    }
    getUsers() {
        return this.http.get<Map<number, String>>(`${this.baseUrl}/users`)
    }

}
