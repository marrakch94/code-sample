import {Injectable} from '@angular/core';
import {HttpInterceptor, HttpHandler, HttpRequest, HttpHeaders, HttpEvent} from '@angular/common/http';
import {Observable} from 'rxjs/internal/Observable';

@Injectable({
    providedIn: 'root'
})
export class AuthInterceptionService implements HttpInterceptor {

    constructor() {
    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        if (req.url.includes('auth') || req.url.includes('forgottenPasswordMail') ||
            req.url.includes('resetPassword') || req.url.includes('signup')) {
            return next.handle(req);

        }
        const clonedRequest = req.clone({
            headers: new HttpHeaders({
                Authorization: localStorage.getItem("ACCESS_TOKEN"),
            })

        })
        return next.handle(clonedRequest);
    }

}
