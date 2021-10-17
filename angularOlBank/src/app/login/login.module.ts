import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {ReactiveFormsModule, FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';


import { LoginComponent } from './login.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule.forChild(routes)
  ],
  declarations: [
    LoginComponent
     // ,ForgotPasswordComponent,ResetPasswordComponent
  ],
  entryComponents: [
      // ForgotPasswordComponent,ResetPasswordComponent
  ],
})
export class LoginComponentModule {}
