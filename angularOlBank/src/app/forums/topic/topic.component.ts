import {
    AfterViewChecked,
    AfterViewInit,
    Component,
    ElementRef,
    Inject,
    OnInit,
    ViewChild
} from '@angular/core';
import { Message } from '../../model/Message';
import { ActivatedRoute } from '@angular/router';
import { MessageService } from '../../service/message.service';
import { Forum } from '../../model/Forum';
import { ForumService } from '../../service/forum.service';
import { DOCUMENT } from '@angular/common';
import { User } from '../../model/User';
import { TopicService } from '../../service/topic.service';
import { WebSocketService } from 'src/app/service/web-socket.service';
import {AngularEditorConfig} from '@kolkov/angular-editor';


@Component({
    selector: 'app-topic',
    templateUrl: './topic.component.html',
    styleUrls: ['./topic.component.css'],
})
export class TopicComponent implements OnInit, AfterViewInit {
    @ViewChild('target') private myScrollContainer!: ElementRef;
    forum: Forum = new Forum(0);
    forumId!: number;
    websocketAPI: any;
    message!: Message;
    listMessage2!: Message[];
    messageTxt = '';
    stringMessage: any;
    user: User;
    admin = false;
    listUsers: Map<number, String> = new Map<number, String>();
    editorConfig: AngularEditorConfig = {
        editable: true,
        uploadUrl: 'http://localhost:8082/image/skellige',
        toolbarHiddenButtons: [
            [
                'strikeThrough',
                'subscript',
                'superscript',
                'justifyLeft',
                'justifyCenter',
                'justifyRight',
                'justifyFull',

            ],
            [
            'customClasses',
            'link',
            'unlink',
            'insertVideo',
            'insertHorizontalRule',
            'removeFormat',
            'toggleEditorMode'
            ]
        ]

    }


    constructor(private activatedRoute: ActivatedRoute,
        private messageService: MessageService,
        private webSocketService: WebSocketService,
        private forumService: ForumService,
        private agent: TopicService,
        @Inject(DOCUMENT) document,
        // private webSocketService : WebSocketService
    ) { /*this.websocketAPI= new WebSocketAPI(new ForumsComponent()); */
    }

    ngAfterViewInit(): void {
        this.refreshLikeDislike();
    }

    ngOnInit(): void {
        this.user = this.currentUserValue();
        this.activatedRoute.paramMap.subscribe(params => {
            this.forumId = +(params.get('forumId') + '');
        })
        this.messageService.getUsers()
            .subscribe({ next: data => this.listUsers = data, complete: () => this.admin = this.roleAdmin(this.user) });
        this.forumService.getByForumId(this.forumId).subscribe(data => this.forum = data)
        this.refreshMessageList();
        this.messageService.listen(this.forumId).subscribe(message => {
            this.handleMessage(message);
        });
    }

    connect() {
        this.webSocketService.connect('');
    }

    disconnect() {
        this.webSocketService.close();
    }

    sendMessageHtml() {
        if(this.messageTxt!=='') {
        this.messageService.send(this.createMessage());
        this.messageTxt=''}
    }

    sendMessage(message: Message) {
        this.messageService.send(message);
    }

    deleteMessage(message: Message) {
        this.messageService.delete(message);
    }

    handleMessage(message) {
        let mx: Message = JSON.parse(message);
        console.log('**************************' + mx.forum.forumId)
        console.log('########### ok');
        if (this.listMessage2.some(x => x.messageId == mx.messageId)) {
            this.agent.updateArrayItem(mx, this.listMessage2);
            setTimeout(() => {
                this.changeColorIflikeOrDislike(mx, this.user.id.toString())
            }, 1)
        } else if (mx.messageId < 0) {
            this.agent.removeArrayItem(mx, this.listMessage2)
        } else {
            this.listMessage2.push(mx);
        }
    }

    refreshMessageList() {
        this.messageService.getByForumId(this.forumId).subscribe(data =>
            this.listMessage2 = data);
    }

    refreshLikeDislike() {
        this.messageService.getByForumId(this.forumId).subscribe(z =>
            this.listMessage2.forEach(x => {
                this.changeColorIflikeOrDislike(x, this.user.id.toString())
                this.message = this.listMessage2[0];
            }
            ))
    }

    scroll(id) {
        const el = document.getElementById(id)!;
        el.scrollIntoView();
    }

    delay(ms: number) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }

    likeMethod(m: Message) {
        if (this.agent.findStrInStr(this.user.id.toString(), m.likingUserList)) {
            m.nbrLike--;
            m.likingUserList = this.agent.removeStrFromStr(this.user.id.toString(), m.likingUserList)
            this.changeStyle('l' + m.messageId, false)
            this.sendMessage(m);
        } else {
            if (!this.agent.findStrInStr(this.user.id.toString(), m.disLikingUserList)) {
                m.nbrLike++
                m.likingUserList = this.agent.addStrtoStr(this.user.id.toString(), m.likingUserList)
                this.changeStyle('l' + m.messageId, true)
                this.sendMessage(m);
            }
        }
    }

    disLikeMethod(m: Message) {
        if (this.agent.findStrInStr(this.user.id.toString(), m.disLikingUserList)) {
            m.nbrDisLike--;
            m.disLikingUserList = this.agent.removeStrFromStr(this.user.id.toString(), m.disLikingUserList)
            this.changeStyle('d' + m.messageId, false)
            this.sendMessage(m);
        } else {
            if (!this.agent.findStrInStr(this.user.id.toString(), m.likingUserList)) {
                m.nbrDisLike++
                m.disLikingUserList = this.agent.addStrtoStr(this.user.id.toString(), m.disLikingUserList)
                this.changeStyle('d' + m.messageId, true)
                this.sendMessage(m);
            }
        }
    }

    createMessage(): Message {
        return new Message(this.user.id, new Forum(this.forumId), this.messageTxt)
    }

    changeStyle(id: string, status: boolean) {
        if (status) {
            if (id.charAt(0) === 'l') {
                document.getElementById(id).setAttribute('style', 'color: mediumseagreen');
            } else {
                document.getElementById(id).setAttribute('style', 'color: darkred');
            }
        } else {
            document.getElementById(id).setAttribute('style', '');
        }
    }

    changeColorIflikeOrDislike(x: Message, user) {
        if (this.agent.findStrInStr(user, x.likingUserList)) {
            this.changeStyle('l' + x.messageId, true)
        }
        if (this.agent.findStrInStr(user, x.disLikingUserList)) {
            this.changeStyle('d' + x.messageId, true)
        }

    }

    dateFormat(date: Date) {
        // let x= new Date(date).toJSON().slice(0,10).replace(/-/g,'/');
        let x = new Date(date).toLocaleString('fr-FR');
        return x;
    }

    currentUserValue(): User {
        const value = localStorage.getItem('currentUser');
        return JSON.parse(value);
    }

    roleAdmin(user: User): boolean {
        return (user.roles && user.roles[0]) ? user.roles[0].name === 'ROLE_ADMIN' : false;
    }
}
