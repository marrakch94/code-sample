import { Component, OnInit } from '@angular/core';
import { NotificationService } from '../service/notification.service';
import {User} from "../model/User";
declare const $: any;
declare interface RouteInfo {
  path: string;
  title: string;
  icon: string;
  class: string;
}
export const ROUTES: RouteInfo[] = [
  { path: '/dashboard', title: 'Dashboard', icon: 'pe-7s-graph', class: '' },
  { path: '/signup', title: 'User Profile', icon: 'pe-7s-user', class: '' },
  { path: '/userslist', title: 'User List', icon: 'pe-7s-note2', class: '' },
  { path: '/typography', title: 'Typography', icon: 'pe-7s-news-paper', class: '' },
  { path: '/icons', title: 'Icons', icon: 'pe-7s-science', class: '' },
  { path: '/maps', title: 'Maps', icon: 'pe-7s-map-marker', class: '' },
  { path: '/notifications', title: 'Notifications', icon: 'pe-7s-bell', class: '' },
  { path: '/my-notifications', title: 'Notifications', icon: 'pe-7s-bell', class: '' },
  { path: '/request/list', title: 'Request', icon: 'pe-7s-paper-plane', class: '' },
  { path: '/forums', title: 'Forums', icon: 'pe-7s-chat', class: '' },

];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html'
})
export class SidebarComponent implements OnInit {
  menuItems: any[];
  notifs = [];
  currentUser: User;
  constructor(private notificationService: NotificationService) {
    this.currentUserValue();
  }

  ngOnInit() {

    this.notificationService.listen().subscribe(notifications => {
      this.notifs.push(notifications.body)
    });
    this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
    if ($(window).width() > 991) {
      return false;
    }
    return true;
  };
  public currentUserValue() {
    const value = localStorage.getItem("currentUser");
    this.currentUser = JSON.parse(value);
    console.log(this.currentUser);
    const name = this.currentUser.name + ' ' + this.currentUser.surname
    return name;
  }
}
