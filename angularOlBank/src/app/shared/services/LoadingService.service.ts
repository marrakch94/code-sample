import {Injectable} from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class LoadingService {

    isLoading = false;

    constructor() {
    }

    async present() {
        this.isLoading = true;
        // return await this.loadingController.create({
        // //  duration: 3000,
        // }).then(a => {
        //   a.present().then(() => {
        //     if (!this.isLoading) {
        //       a.dismiss().then(() => {});
        //     }
        //   });
        // });
    }

    async dismiss() {
        this.isLoading = false;
        // return await this.loadingController.dismiss().then(() => {});
    }
}
