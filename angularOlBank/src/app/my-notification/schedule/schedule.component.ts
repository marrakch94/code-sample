import { Component, OnInit } from '@angular/core';
import { map } from 'rxjs/operators';
import { NotificationDef } from 'src/app/model/NotificationDef';
import { NotificationService } from 'src/app/service/notification.service';

interface Schedule {
  title: string;
  cron: string;
}

@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {

  notifs: NotificationDef[];
  headers = ['Notification', 'Users', 'Schedule', 'Action'];
  selected: number;
  users = ['User 1', 'User 2', 'User 3'];
  selectedUsers = [];
  crons: Schedule[] = [
    {
      title: 'Every Minute',
      cron: '0 * * * * *'
    }, {
      title: 'Every Day',
      cron: '0 1 1 * * *'
    }, {
      title: 'Every Month',
      cron: '0 0 0 1 1/1 *'
    },
    {
      title: 'Every Year',
      cron: '0 0 1 1 12 ?'
    }
  ];
  constructor(private notificationService: NotificationService) { }

  ngOnInit(): void {
    this.notificationService.getAll().pipe(map(n => n.filter(notif => notif.schedule))).subscribe(notifs => {
      this.notifs = notifs;
    });
  }

  close() {
    console.log(close);
  }

  selectUser(user){
    console.log(user);
  }
}
