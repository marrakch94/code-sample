import {Injectable} from '@angular/core';
import {AuthService} from './auth.service';
import {Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot} from '@angular/router';
import {User} from "../model/User";

@Injectable({
    providedIn: 'root'
})
export class AuthGuardService implements CanActivate {
    public currentUser: User;

    constructor(private authService: AuthService, private router: Router) {
    }


    canActivate(route: ActivatedRouteSnapshot): boolean {
        const exp = route.data.name;
        let data;
        console.log('exp :' + exp);
        const value = localStorage.getItem("currentUser");
        this.currentUser = JSON.parse(value);
        if (this.currentUser.roles[0].name) {
            data = this.currentUser.roles[0].name;
        }
        // else {
        //     data == 'ROLE_USER';
        // }
        // //data = this.currentUser.authorities;
        if (localStorage.getItem("ACCESS_TOKEN") != null) {
            for (let i = 0; i < data.length; i++) {
                const x = JSON.stringify(this.currentUser.roles[i]);
                const role = JSON.parse(x);
                // console.log("role"+role.name);
                if ((role.name === exp) || (typeof exp === 'undefined')) {
                    console.log('x :' + x);
                    console.log("Yes" + route.pathFromRoot + exp + role.name);
                    return this.authService.isLogged();
                    // }
                }
                // else {
                this.router.navigateByUrl('login');
                // console.log("No")
                // return false;
                // }
            }

        }
    }
}
