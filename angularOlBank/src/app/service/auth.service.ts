import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {tap} from 'rxjs/operators';
import {BehaviorSubject} from 'rxjs';
import {Router} from '@angular/router';
import {Context} from "../shared/services/context.service";
import {AuthRequest} from "../model/AuthRequest";
import {User} from "../model/User";

@Injectable({
    providedIn: 'root'
})
export class AuthService {
    public currentUser: User;
    public authSubject = new BehaviorSubject(false);// authentificationState
    constructor(private httpClient: HttpClient, private router: Router) {
        this.checkToken();
        // this.currentUser =this.authSubject.asObservable();
    }

    async checkToken() {

        if (!this.isLogged()) {
            // if (localStorage.getItem("currentUser") != null){
            //   console.log('Not Allowdd');
            //   this.router.navigateByUrl('statistics');
            // }
            // else{
            this.router.navigateByUrl('login');
            // }

        }
    }


    login(authRequest: AuthRequest) {
        return this.httpClient.post<any>(Context.apiUrl + "auth", authRequest).pipe(tap(async (res) => {
            if (res) {
                console.log(res.user);
                localStorage.setItem('currentUser', JSON.stringify(res.user));
                localStorage.setItem('ACCESS_TOKEN', "Bearer " + res.token)
            } else {
            }
        }))
    }

    async logout() {
        await this.authSubject.next(false);
        localStorage.removeItem("currentUser");
        localStorage.removeItem("ACCESS_TOKEN");
        await this.router.navigate(["/login"]);
    }

    isLogged() {
        if (localStorage.getItem("ACCESS_TOKEN") != null) {
            // var value = localStorage.getItem("currentUser");
            // this.currentUser = JSON.parse(value);
            // var data = this.currentUser.authorities[0].name;
            // if (data == exp) {
            return true;
            // }
            // else  {
            //   console.log('Not Allowdd');
            //   // this.router.navigateByUrl('/test');
            // //   // return true;
            // }
            // else  {
            // this.authSubject.next(false);
            // }
        }
        return false;
    }

    emailToRecommendedPatient(patient) {
        return this.httpClient.post<any>(Context.apiUrl + 'emailRecommendedPatient', patient);
    }
}
