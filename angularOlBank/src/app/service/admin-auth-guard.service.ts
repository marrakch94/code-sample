import {Injectable} from '@angular/core';
import {AuthService} from './auth.service';
import {Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs';
import {User} from "../model/User";

@Injectable({
    providedIn: 'root'
})
export class AdminAuthGuardService implements CanActivate {
    currentUser: User;

    constructor(private authService: AuthService, private router: Router) {
    }


    isAdmin() {
        const value = localStorage.getItem("currentUser");
        this.currentUser = JSON.parse(value);
        if (this.currentUser) {
            return (this.currentUser.roles[0].name === "ROLE_ADMIN");
        }
        return false;
    }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot):
        boolean | Observable<boolean> | Promise<boolean> {
        if (this.isAdmin() && this.authService.isLogged()) {
            return true;
        } else {
            return false;
        }
    }
}
