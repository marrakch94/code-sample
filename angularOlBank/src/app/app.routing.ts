import {NgModule} from '@angular/core';
import {CommonModule,} from '@angular/common';
import {BrowserModule} from '@angular/platform-browser';
import {Routes, RouterModule} from '@angular/router';

import {AdminLayoutComponent} from './layouts/admin-layout/admin-layout.component';
import {ContradictoryAuthGuardService} from "./service/contradictory-auth-guard.service";
import {AuthGuardService} from "./service/auth-guard.service";
import {SignupComponent} from "./user/signup/signup.component";


const routes: Routes = [
    {
        path: '',
        redirectTo: 'dashboard',
        pathMatch: 'full',
    }, {
        path: '',
        component: AdminLayoutComponent,
        children: [
            {path: '', loadChildren: './layouts/admin-layout/admin-layout.module#AdminLayoutModule'},
            // {path: '', loadChildren: () => import('./layouts/admin-layout/admin-layout.module').then(m => m.AdminLayoutModule)}
        ],
    },
    {
        path: 'login', loadChildren: './login/login.module#LoginComponentModule',
        canActivate: [ContradictoryAuthGuardService]
    },
    {
        path: 'signup', component: SignupComponent,
        canActivate: []
    },
    {path: '**', redirectTo: 'dashboard'},

];

@NgModule({
    imports: [
        CommonModule,
        BrowserModule,
        RouterModule.forRoot(routes, {
            useHash: false
        })
    ],
    exports: [],
})
export class AppRoutingModule {
}
