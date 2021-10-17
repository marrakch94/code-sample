export class Stat {
    title: string;
    valueN: number;
    valueNMinus1: number;
    evolution: number;
    constructor(title: string, valueN: number, evolution: number) {
        this.title = title;
        this.valueN = valueN;
        this.evolution = evolution;
    }
}
