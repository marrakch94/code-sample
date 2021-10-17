import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {Context, InjectedContext} from "../shared/services/context.service";
import {AuthService} from "../service/auth.service";


@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {

    loginForm: FormGroup;
    registerLink: string;
    msgSuccess = 'Email envoyé';
    wrongCredentials = 'Email ou mot de passe incorrect.';
    wrongMail = 'Vous avez déjà un compte ou email incorrect';
    passwordType = 'password';
    username = 'username';
    passwordShown = false;
    submitClicked = false;

    loading;

    constructor(private authService: AuthService, private router: Router,
                private formBuilder: FormBuilder, private context: Context,
                // private customLoadingService: CustomLoadingService, private gabritService: GabaritService,
                // private userService: UserService ,private customToastService: CustomToastService,
                // public alertCtrl: AlertController, private modalCtrl: ModalController,
    ) {

        InjectedContext.Fromlogout = true;
        // this.isDesktop = this.context.detectPlatformDesktop();
        this.createForm();

    }

    createForm() {
        this.loginForm = this.formBuilder.group({
            username: ['', [Validators.required, Validators.minLength(3)]],
            password: ['', [Validators.required, Validators.minLength(6)]],
        });
    }

    tooglePassword() {
        if (this.passwordShown) {
            this.passwordShown = false;
            this.passwordType = 'password';
        } else {
            this.passwordShown = true;
            this.passwordType = 'text';
        }
    }

    async ngOnInit() {
    }

    async login(form) {
        console.log(form.value);
        this.submitClicked = true;
        if (this.loginForm.invalid) {
            return;
        }
        // this.customLoadingService.presentLoading().then(async value => {
        this.authService.login(form.value).subscribe(async (res) => {
            if (res) {
                // await this.initContextVars();
                this.router.navigate(['/dashboard']);
            }
        }, err => {
            // this.customToastService.presentToast(this.wrongCredentials, toastTypeColor.red, toastTime.long);
            // this.customLoadingService.dismissLoading();
        });
        // });
    }

    // async initContextVars() {
    //     const result = Promise.all([
    //         // await this.gabritService.getAllGabarit().toPromise(),
    //         // await this.userService.getSmall("").toPromise(),
    //     ]);
    //     result.then(async result1 => {
    //         // InjectedContext.GabaritOutils = result1[0];
    //         // InjectedContext.listPraticien = result1[1]
    //     })
    // }

    async forgotPassword() {
        // let classCss = this.isDesktop ? 'custom-modal-pass-desk' : 'custom-modal-pass';
        // const modal = await this.modalCtrl.create({
        //     component: ForgotPasswordComponent,
        //     cssClass: classCss
        // });
        // modal.present();
    }
}
