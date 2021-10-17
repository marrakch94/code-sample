export enum NotifType {
    EMAIL, WEB, BOTH
}
export enum NotifTarget {
    USER, ADMIN, ALL, UNSPECIFIED
}

export class NotificationDef {
    id: number;
    title: string;
    body: string;
    type: NotifType;
    target: NotifTarget;
    action: string;
    default: boolean;
    schedule: boolean;
    constructor() { }
}