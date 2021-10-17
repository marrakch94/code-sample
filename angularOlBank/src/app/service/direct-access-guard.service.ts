import {Injectable} from '@angular/core';
import {Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';
import {Observable} from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class DirectAccessGuardService implements CanActivate {

    constructor(private router: Router) {
    }

    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
        if (this.router.url === '/') {
            this.router.navigate(['']);
            return false;
        }
        return true;
    }
}
