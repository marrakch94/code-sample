import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { LbdModule } from '../../lbd/lbd.module';
import { NguiMapModule } from '@ngui/map';

import { AdminLayoutRoutes } from './admin-layout.routing';

import { HomeComponent } from '../../home/home.component';
import { UserComponent } from '../../user/user.component';
import { TablesComponent } from '../../tables/tables.component';
import { TypographyComponent } from '../../typography/typography.component';
import { IconsComponent } from '../../icons/icons.component';
import { MapsComponent } from '../../maps/maps.component';
import { NotificationsComponent } from '../../notifications/notifications.component';
import { UpgradeComponent } from '../../upgrade/upgrade.component';
import { ForumsComponent } from '../../forums/forums.component';
import { TopicComponent } from '../../forums/topic/topic.component';
import { CreateTopicComponent } from '../../forums/create-topic/create-topic.component';
import { ForumBiComponent } from '../../forums/forum-bi/forum-bi.component';

import { AngularEditorModule } from '@kolkov/angular-editor';
import { FlexLayoutModule } from '@angular/flex-layout';
import { ScheduleComponent } from '../../my-notification/schedule/schedule.component';
import { ChipsComponent } from '../../my-notification/chips/chips.component';
import { MyNotificationComponent } from 'src/app/my-notification/my-notification.component';
import { PreviewComponent } from 'src/app/my-notification/preview/preview.component';
import { RequestListComponent } from '../../request/request-list/request-list.component';
import { RequestCreateComponent } from '../../request/request-create/request-create.component';
import { RequestDetailComponent } from '../../request/request-detail/request-detail.component';
import { RequestUpdateComponent } from '../../request/request-update/request-update.component';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(AdminLayoutRoutes),
    FormsModule,
    LbdModule,
    AngularEditorModule,
    FlexLayoutModule,
    NguiMapModule.forRoot({ apiUrl: 'https://maps.google.com/maps/api/js?key=YOUR_KEY_HERE' })
  ],
  declarations: [
    HomeComponent,
    UserComponent,
    TablesComponent,
    TypographyComponent,
    IconsComponent,
    MapsComponent,
    NotificationsComponent,
    UpgradeComponent,
    ForumsComponent,
    TopicComponent,
    MyNotificationComponent,
    PreviewComponent,
    ScheduleComponent,
    ChipsComponent,
    CreateTopicComponent,
    ForumBiComponent,
    RequestListComponent,
    RequestCreateComponent,
    RequestDetailComponent,
    RequestUpdateComponent
  ]
})
export class AdminLayoutModule { }
