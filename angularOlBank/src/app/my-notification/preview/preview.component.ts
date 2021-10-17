import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, ActivatedRouteSnapshot } from '@angular/router';
import { Observable } from 'rxjs';
import { NotificationDef } from 'src/app/model/NotificationDef';
import { NotificationService } from 'src/app/service/notification.service';

@Component({
  selector: 'app-preview',
  templateUrl: './preview.component.html',
  styleUrls: ['./preview.component.css']
})
export class PreviewComponent implements OnInit {

  notif$: Observable<NotificationDef>;

  constructor(private notificationService: NotificationService, private activeRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.notif$ = this.notificationService.getOne(this.activeRoute.snapshot.params.id)
  }

}
