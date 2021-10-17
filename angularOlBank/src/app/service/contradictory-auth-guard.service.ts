import {Injectable} from '@angular/core';
import {AuthService} from './auth.service';
import {Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';

@Injectable({
    providedIn: 'root'
})
export class ContradictoryAuthGuardService implements CanActivate {

    constructor(private authService: AuthService, private router: Router) {
    }

    canActivate(): boolean {
        return !localStorage.getItem("ACCESS_TOKEN");
    }
}
