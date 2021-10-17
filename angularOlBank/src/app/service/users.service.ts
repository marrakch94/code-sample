import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Context} from "../shared/services/context.service";
import {User} from "../model/User";
import {Role} from "../model/Role";

@Injectable({
    providedIn: 'root'
})
export class UsersService {

    constructor(private http: HttpClient) {
    }

    getUser(id: number) {
        return this.http.get<User>(Context.apiUrl + 'UserById/' + id);
    }

    getAllUsers() {
        return this.http.get<User[]>(Context.apiUrl + 'Users');
    }

    addUser(user: FormData) {
        return this.http.post<User>(Context.apiUrl + 'AddUser', user);
    }
    signUp(user: FormData) {
        return this.http.post<User>(Context.apiUrl + 'signup', user);
    }

    deleteUser(id: string) {
        return this.http.delete(Context.apiUrl + 'DeleteUser/' + id);
    }

    userStatEnabled() {
        return this.http.get(Context.apiUrl + 'UserStatEnabled');
    }

    userStatDate() {
        return this.http.get(Context.apiUrl + 'UserStatDate');
    }

    public createUsersFromData(form: any, profileImage: File): FormData {
        const formData = new FormData();
        formData.append('userName', form.value.userName);
        formData.append('enabled', form.value.enabled);
        formData.append('codepost', form.value.codepost);
        formData.append('city', form.value.city);
        formData.append('country', form.value.country);
        formData.append('profileImage', profileImage);
        formData.append('phoneNumber', form.value.phoneNumber);
        formData.append('surname', form.value.surname);
        formData.append('name', form.value.name);
        formData.append('adresse', form.value.adresse);
        formData.append('salary', form.value.salary);
        formData.append('naissance', form.value.naissance);
        formData.append('sexe', form.value.sexe);
        formData.append('roles', form.value.roles);
        formData.append('email', form.value.email);
        formData.append('password', form.value.password);
        if (form.value.id !== 0) {
            formData.append('id', form.value.id);
        } else {
            formData.append('id', null);
        }
        console.log(formData);
        //    formData.append('isActive', JSON.stringify(form.value.lastName));
        //    formData.append('isNotLocked', JSON.stringify(form.value.lastName));
        return formData;
    }


}
