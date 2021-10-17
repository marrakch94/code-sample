import { Component, ElementRef, Inject, OnInit, ViewChild } from '@angular/core';
import { Forum } from '../../model/Forum';
import { Message } from '../../model/Message';
import * as pbi from 'powerbi-client';
import { environment } from 'src/environments/environment';
import { ForumService } from '../../service/forum.service';
import { MessageService } from '../../service/message.service';
import { User } from '../../model/User';
import {Observable} from 'rxjs/Observable';
import {of, Subject} from 'rxjs';
declare var $:any;

@Component({
    selector: 'app-create-topic',
    templateUrl: './create-topic.component.html',
    styleUrls: ['./create-topic.component.css']
})
export class CreateTopicComponent implements OnInit {
    report: pbi.Embed;
    @ViewChild('reportContainer', { static: false }) reportContainer: ElementRef;
    forum: Forum = new Forum(null);
    message: Message = new Message(null, null, null);
    forumId: any;
    user: User = null;
    alert = false;
    counter =0;
    observ = new Subject();

    constructor(private forumService: ForumService,
        private messageService: MessageService) {
    }

    ngOnInit(): void {
        this.forum.topic = "";
        this.currentUserValue();
        this.observ.subscribe((value)=>console.log("observ value: "+value));
    }

    createMessage(): boolean {
        if (this.user.id !== null && this.forumId !== null) {
            this.message.dateTime = new Date();
            // console.log("ready to send forum: "+ new Forum(this.forumId))
            this.message.forum = new Forum(this.forumId);
            this.message.userId = this.user.id;
            this.message.nbrLike = 0;
            this.message.nbrDisLike = 0;
            this.message.likingUserList = '';
            this.message.disLikingUserList = '';
            return true;
        }
        return false;
    }

    addForum() {
        this.forum.forumDate = new Date();
        this.forumService.Save(this.forum)
            .subscribe({
                next: data => this.forumId = data,
                complete: () => {
                    if (this.createMessage()) {
                        this.messageService
                        .save(this.message).subscribe({ complete: () => this.alert = true });
                        console.log(this.message);
                        this.forum.topic='';
                        this.message.messageTxt='';
                    }
                }
            })
    }
    currentUserValue() {
        const value = localStorage.getItem("currentUser");
        this.user = JSON.parse(value);
        console.log(this.user);
    }
    increment() {
        //this.observCounter.subscribe(x=>this.counter++);
        this.observ.next(this.counter++);
    }
    showNotification(from, align) {
        const type = ['','info','success','warning','danger'];

        var color = Math.floor((Math.random() * 4) + 1);
        $.notify({
            icon: "pe-7s-gift",
            message: "Welcome to <b>Light Bootstrap Dashboard</b> - a beautiful freebie for every web developer."
        },{
            type: type[color],
            timer: 1000,
            placement: {
                from: from,
                align: align
            }
        });
    }
}



