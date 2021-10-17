import {RouterModule, Routes} from '@angular/router';

import {HomeComponent} from '../../home/home.component';
import {UserComponent} from '../../user/user.component';
import {TablesComponent} from '../../tables/tables.component';
import {TypographyComponent} from '../../typography/typography.component';
import {IconsComponent} from '../../icons/icons.component';
import {MapsComponent} from '../../maps/maps.component';
import {NotificationsComponent} from '../../notifications/notifications.component';
import {UpgradeComponent} from '../../upgrade/upgrade.component';
import {ForumsComponent} from '../../forums/forums.component';
import {TopicComponent} from '../../forums/topic/topic.component';
import {CreateTopicComponent} from '../../forums/create-topic/create-topic.component';
import {ForumBiComponent} from '../../forums/forum-bi/forum-bi.component';
import {ListUsersComponent} from "../../user/list-users/list-users.component";
import {UserUpdateComponent} from "../../user/user-update/user-update.component";
import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {LoginComponent} from "../../login/login.component";
import {AdminLayoutComponent} from "./admin-layout.component";
import {AuthGuardService} from "../../service/auth-guard.service";
import {MyNotificationComponent} from "../../my-notification/my-notification.component";
import {ScheduleComponent} from "../../my-notification/schedule/schedule.component";
import {PreviewComponent} from "../../my-notification/preview/preview.component";
import {RequestListComponent} from "../../request/request-list/request-list.component";
import {RequestUpdateComponent} from "../../request/request-update/request-update.component";
import {RequestDetailComponent} from "../../request/request-detail/request-detail.component";
import {RequestCreateComponent} from "../../request/request-create/request-create.component";

export const AdminLayoutRoutes: Routes = [
    {path: 'dashboard', component: HomeComponent},
    {path: 'user', component: UserComponent},
    {
        path: 'userslist', component: ListUsersComponent,
        canActivate: [AuthGuardService],
        data: {
            name: 'ROLE_ADMIN'
        }
    },
    {path: 'users/:userId', component: UserUpdateComponent,
        canActivate: [AuthGuardService],
        data: {
            name: 'ROLE_ADMIN'
        }},
    {path: 'users', component: UserUpdateComponent,
        canActivate: [AuthGuardService],
        data: {
            name: 'ROLE_ADMIN'
        }},
    {path: 'table', component: TablesComponent},
    {path: 'typography', component: TypographyComponent},
    {path: 'icons', component: IconsComponent},
    {path: 'maps', component: MapsComponent},
    {path: 'notifications', component: NotificationsComponent},
    {path: 'upgrade', component: UpgradeComponent},
    {path: 'forums', component: ForumsComponent},
    {path: 'topic/:forumId', component: TopicComponent},
    {path: 'createTopic', component: CreateTopicComponent},
    {path: 'my-notifications', component: MyNotificationComponent},
    {path: 'my-notifications/preview/:id', component: PreviewComponent},
    {path: 'my-notifications/schedule', component: ScheduleComponent},
    {path: 'request/list', component: RequestListComponent},
    {path: 'client/:id/request/list', component: RequestListComponent},
    {path: 'request/edit/:id', component: RequestUpdateComponent},
    {path: 'request/detail/:id', component: RequestDetailComponent},
    {path: 'request/create', component: RequestCreateComponent},
    {path: 'forumBi', component: ForumBiComponent}
];

@NgModule({
    imports: [
        CommonModule,
        ReactiveFormsModule,
        FormsModule,
        RouterModule.forChild(AdminLayoutRoutes)
    ],
    declarations: [
        // AdminLayoutComponent
        // ,ForgotPasswordComponent,ResetPasswordComponent
    ],
    entryComponents: [
        // ForgotPasswordComponent,ResetPasswordComponent
    ],
})
export class AdminLayoutRouting {
}
