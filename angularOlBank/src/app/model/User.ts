export class User {

    constructor() {
        this.userName = '';
        this.password = '';
        this.telephone = '';
        this.email = '';
        this.sexe = '';
        this.titre = '';
        this.salary = '';
        this.adresse = '';
        this.name = '';
        this.surname = '';
        this.phoneNumber = '';
        this.country = '';
        this.city = '';
        this.codepost = '';
        this.enabled = false;
        this.profileImageUrl = '';
    }

    id: number;
    userName: string;
    password: string;
    firstName: string;
    lastName: string;
    telephone: string;
    email: string;
    roles: any;
    sexe: string;
    titre: string;
    naissance: Date;
    salary: string;
    adresse: string;
    name: string;
    surname: string;
    phoneNumber: string;
    country: string;
    city: string;
    codepost: string;
    enabled: boolean;
    lastPasswordResetDate: Date;
    joinDate: Date;
    profileImageUrl: string;
}




