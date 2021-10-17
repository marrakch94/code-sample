import {Component, OnInit} from '@angular/core';
import {ForumService} from '../service/forum.service';
import {Observable} from 'rxjs';
import {ForumView} from '../model/ForumView';
import {Router} from '@angular/router';
import {ForumMatch} from '../model/ForumMatch';
import {WordService} from '../service/word.service';
import {User} from '../model/User';

@Component({
    selector: 'app-forums',
    templateUrl: './forums.component.html',
    styleUrls: ['./forums.component.css']
})
export class ForumsComponent implements OnInit {
    listForum!: Observable<ForumView[]>;
    forumService;
    topic;
    listForumMatch: ForumMatch[] = [];
    loadComponent=false;
    admin = false;

    constructor(forumService: ForumService, private readonly router: Router,private wordService: WordService) {
        this.forumService = forumService;
    }

    ngOnInit(): void {
        this.refreshForumList();
        this.admin= this.roleAdmin(this.currentUserValue());
    }

    refreshForumList() {
        // this.listForum= this.forumService.getAllSub();
        this.forumService.getRecap().subscribe(() => this.listForum = this.forumService.getRecap())
    }

    navigate(id) {
        this.router.navigateByUrl(id);
    }
    refreshForumMatchList() {
        this.forumService.getMatch(this.topic).subscribe(data=>this.listForumMatch=data);
    }
    scroll(el: HTMLElement) {
        el.scrollIntoView();
    }
    currentUserValue():User {
        const value = localStorage.getItem('currentUser');
        return  JSON.parse(value);
    }

    roleAdmin(user: User): boolean {
        return user.roles[0].name === 'ROLE_ADMIN';
    }



}
