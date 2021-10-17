import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable } from 'rxjs/Observable';


@Injectable()
export class AuthInterceptor implements HttpInterceptor {
    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        req = req.clone({
            setHeaders: {
                'Content-Type' : 'application/json; charset=utf-8',
                'Accept'       : 'application/json',
                'Authorization': `Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJNYXJyYWtjaGkyIiwiZXhwIjoxNjI2NjkxNzY1LCJpYXQiOjE2MjYwODY5NjV9.PZOUmAGPOgPWtW7ar8t6CNbuTWevi_S5_G5MrYiHyjPdsobHXqwhge6NRCAsfn5h0qve5oP5E1eEH3EmOdVgyg`,
            },
        });

        return next.handle(req);
    }
}

