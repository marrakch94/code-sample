import {Component, OnInit, ElementRef} from '@angular/core';
import {ROUTES} from '../../sidebar/sidebar.component';
import {Location, LocationStrategy, PathLocationStrategy} from '@angular/common';
import {AuthService} from "../../service/auth.service";
import {User} from "../../model/User";
import {NotificationService} from 'src/app/service/notification.service';

@Component({
    // moduleId: module.id,
    selector: 'navbar-cmp',
    templateUrl: 'navbar.component.html'
})

export class NavbarComponent implements OnInit {
    private listTitles: any[];
    location: Location;
    private toggleButton: any;
    private sidebarVisible: boolean;
    currentUser: User;
    notifs = [];

    constructor(location: Location, private element: ElementRef, private authService: AuthService, private notificationService: NotificationService) {
        this.location = location;
        this.sidebarVisible = false;
        this.currentUserValue();
    }

    ngOnInit() {
        this.listTitles = ROUTES.filter(listTitle => listTitle);
        const navbar: HTMLElement = this.element.nativeElement;
        this.toggleButton = navbar.getElementsByClassName('navbar-toggle')[0];
        this.notificationService.listen().subscribe(notifications => {
            this.notifs.push(notifications.body)
            console.log(notifications);
        })
    }

    sidebarOpen() {
        const toggleButton = this.toggleButton;
        const body = document.getElementsByTagName('body')[0];
        setTimeout(function () {
            toggleButton.classList.add('toggled');
        }, 500);
        body.classList.add('nav-open');

        this.sidebarVisible = true;
    };

    sidebarClose() {
        const body = document.getElementsByTagName('body')[0];
        this.toggleButton.classList.remove('toggled');
        this.sidebarVisible = false;
        body.classList.remove('nav-open');
    };

    sidebarToggle() {
        // const toggleButton = this.toggleButton;
        // const body = document.getElementsByTagName('body')[0];
        if (this.sidebarVisible === false) {
            this.sidebarOpen();
        } else {
            this.sidebarClose();
        }
    };

    getTitle() {
        var titlee = this.location.prepareExternalUrl(this.location.path());
        if (titlee.charAt(0) === '#') {
            titlee = titlee.slice(1);
        }

        for (var item = 0; item < this.listTitles.length; item++) {
            if (this.listTitles[item].path === titlee) {
                return this.listTitles[item].title;
            }
        }
        return 'Dashboard';
    }

    logout() {
        this.authService.logout();
    }

    public currentUserValue() {
        const value = localStorage.getItem("currentUser");
        this.currentUser = JSON.parse(value);
        console.log(this.currentUser);
        const name = this.currentUser.name + ' ' + this.currentUser.surname
        return name;
    }
}
