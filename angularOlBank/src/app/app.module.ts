import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import { RouterModule } from '@angular/router';
import {CommonModule} from '@angular/common';

import { AppRoutingModule } from './app.routing';
import { NavbarModule } from './shared/navbar/navbar.module';
import { FooterModule } from './shared/footer/footer.module';
import { SidebarModule } from './sidebar/sidebar.module';

import { AppComponent } from './app.component';

import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import {LoginComponentModule} from "./login/login.module";
import {AuthInterceptionService} from "./shared/services/auth-interception.service";
import { ListUsersComponent } from './user/list-users/list-users.component';
import { UserUpdateComponent } from './user/user-update/user-update.component';
import { SignupComponent } from './user/signup/signup.component';
import {LbdModule} from "./lbd/lbd.module";

@NgModule({
    imports: [
        BrowserAnimationsModule,
        FormsModule,
        RouterModule,
        HttpClientModule,
        NavbarModule,
        FooterModule,
        LoginComponentModule,
        SidebarModule,
        AppRoutingModule,
        CommonModule,
        ReactiveFormsModule,
        LbdModule,
    ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    ListUsersComponent,
    UserUpdateComponent,
    SignupComponent,
  ],
  providers: [,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptionService,
      multi : true
    }],
  bootstrap: [AppComponent]
})

export class AppModule { }
