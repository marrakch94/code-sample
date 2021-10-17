import { Component, OnInit } from '@angular/core';
import { NotificationService } from '../service/notification.service';
import { NotificationDef, NotifTarget, NotifType } from '../model/NotificationDef';
declare var $: any;

@Component({
  selector: 'app-my-notification',
  templateUrl: './my-notification.component.html',
  styleUrls: ['./my-notification.component.css']
})
export class MyNotificationComponent implements OnInit {

  htmlContent;
  title;
  notifs = [];
  selected = null;
  type;
  isSchedule;
  target = NotifTarget.UNSPECIFIED;

  constructor(private notificationService: NotificationService) { }

  ngOnInit(): void {
    this.loadNotifs();
  }

  loadNotifs() {
    this.notificationService.getAll().subscribe(notifs => {
      this.notifs = notifs;
    });
  }

  save() {
    if (this.selected) {
      const notif = this.getNotificationDef();
      notif.id = this.selected.id;
      this.notificationService.update(notif).subscribe(res => {
        this.loadNotifs();
        this.showNotification('bottom', 'right', 'Update');
      })
    } else {
      const notif = this.getNotificationDef();
      this.notificationService.save(notif).subscribe((notification: NotificationDef) => {
        this.loadNotifs();
        this.select(notification);
        this.showNotification('bottom', 'right', 'Save');
      });
    }
  }

  delete(notif: NotificationDef) {
    this.notificationService.delete(notif).subscribe(res => {
      this.reset();
      this.loadNotifs();
      this.showNotification('Delete', 'right', 'Save');
    });
  }

  select(notif: NotificationDef) {
    this.selected = notif;
    this.htmlContent = this.selected.body;
    this.title = this.selected.title;
    this.type = this.selected.type;
    this.target = this.selected.target;
    this.isSchedule = this.selected.schedule;
  }

  new() {
    this.reset();
  }

  getNotificationDef() {
    const notif = new NotificationDef();
    notif.body = this.htmlContent;
    notif.title = this.title;
    notif.type = this.type;
    notif.target = this.target;
    notif.schedule = this.isSchedule;
    return notif;
  }

  reset() {
    this.selected = null;
    this.htmlContent = null;
    this.title = null;
    this.type = null;
    this.isSchedule = false;
    this.target = NotifTarget.UNSPECIFIED;
  }

  showNotification(from, align, text) {
    $.notify({
      icon: "pe-7s-star",
      message: `${text} Success`
    }, {
      type: 'success',
      timer: 1000,
      placement: {
        from: from,
        align: align
      }
    });
  }
}
