import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import {AuthInterceptionService} from "../shared/services/auth-interception.service";

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    HttpClientModule,
    FormsModule,
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptionService,
      multi : true
    }
  ]
})
export class AuthModule { }
