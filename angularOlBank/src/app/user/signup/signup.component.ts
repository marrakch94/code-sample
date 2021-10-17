import {Component, OnInit} from '@angular/core';
import {User} from "../../model/User";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {UsersService} from "../../service/users.service";

@Component({
    selector: 'app-signup',
    templateUrl: './signup.component.html',
    styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
    userId: number;
    user: User = new User();
    userForm: FormGroup;
    currentUser: User;
    profileImage: File;
    public fileName: string;
    submitClicked = false;
    username = 'username';
    email = 'email';

    constructor(private activatedRoute: ActivatedRoute, private userService: UsersService,
                private formBuilder: FormBuilder, private router: Router) {
        this.activatedRoute.paramMap.subscribe(params => {
            this.userId = +(params.get('userId'));
        });
        console.log(this.user,this.userId);
        if (this.userId !== 0) {
            this.userService.getUser(this.userId).subscribe(res => {
                this.user = res;
                if (this.userId !== res.id) {
                    return
                }
                this.createForm(res);
                this.currentUserValue();
            });
        } else {
            this.createForm(this.user);
        }
    }

    ngOnInit(): void {
    }

    createForm(user: User) {
        console.log(user.userName);
        let roles = "";
        if (user.roles !== undefined) {
            roles = user.roles[0].name
        }
        this.userForm = this.formBuilder.group({
            password: ["", [Validators.required, Validators.minLength(6)]],
            id: [user.id],
            name: [user.name, [Validators.required, Validators.minLength(3)]],
            surname: [user.surname, [Validators.required, Validators.minLength(3)]],
            email: [user.email, [Validators.required,Validators.email]],
            adresse: [user.adresse, [Validators.required]],
            salary: [user.salary, [Validators.required]],
            userName: [user.userName, [Validators.required, Validators.minLength(4)]],
            phoneNumber: [user.phoneNumber, [Validators.required]],
            country: [user.country, [Validators.required]],
            city: [user.city, [Validators.required]],
            codepost: [user.codepost, [Validators.required]],
            enabled: [user.enabled],
            roles: [roles],
            profileImage: new FormControl(null, [Validators.required])
        });

    }

    public currentUserValue() {
        const value = localStorage.getItem("currentUser");
        this.currentUser = JSON.parse(value);
        console.log(this.currentUser);
        const name = this.currentUser.name + ' ' + this.currentUser.surname
        return name;
    }

    async sendUser(form) {
        this.submitClicked = true;
        if (this.userForm.invalid) {
            return this.router.navigate(["/login"]);
        }
        if (form.value.roles === 'Admin') {
            form.value.roles = 'ROLE_ADMIN';
        } else {
            form.value.roles = 'ROLE_USER'
        }
        const formData = this.userService.createUsersFromData(form, this.profileImage);
        console.log(formData, this.profileImage);
        this.userService.signUp(formData).subscribe(async (res) => {
            if (res) {
                setTimeout(() => {
                        this.router.navigate(['/login']);
                    },
                    1000);
                console.log(res);
               // this.router.navigate(["/login"]);
            }
        });
    }

    public onProfileImageChange(fileName: string, profileImage: File): void {
        this.fileName = fileName;
        this.profileImage = profileImage;
    }


}
