import {Injectable, Injector} from '@angular/core';
import {HttpClient, HttpXhrBackend} from '@angular/common/http';
import {environment} from '../../../environments/environment';


@Injectable({
    providedIn: 'root'
})
export class Context {


    static get apiUrl() {
        return environment.apiUrl;
    }

    static get folder() {
        return environment.folder;
    }


    constructor(
        private http: HttpClient) {

    }
}

export class InjectedContext {
    protected static injectedContext: InjectedContext;
    public static Fromlogout;
    public static dataEmptyMessage = 'aucune donnée à afficher';
    public static GabaritOutils: any = [];
    public static listPraticien: any = [];


    // private static connexion(): HttpClient {
    //
    //     const xhrFactoryInjector = Injector.create([
    //         {provide: BrowserXhr, useClass: BrowserXhr, deps: []}
    //     ]);
    //
    //     const httpHandlerInjector = Injector.create([
    //         {provide: HttpXhrBackend, useClass: HttpXhrBackend, deps: [BrowserXhr]}
    //     ], xhrFactoryInjector);
    //
    //
    //     const httpClientInjector = Injector.create([
    //         {provide: HttpClient, useClass: HttpClient, deps: [HttpXhrBackend]}
    //     ], httpHandlerInjector);
    //     const httpClient: HttpClient = httpClientInjector.get(HttpClient);
    //     return httpClient;
    // }


}
