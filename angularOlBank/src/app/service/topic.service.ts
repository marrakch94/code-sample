import { Injectable } from '@angular/core';
import {Message} from '../model/Message';

@Injectable({
  providedIn: 'root'
})
export class TopicService {

  constructor() { }

  dateFormat(date:Date) {
    // let x= new Date(date).toJSON().slice(0,10).replace(/-/g,'/');
    let x= new Date(date).toLocaleString('fr-FR');
    return x;
  }
  removeStrFromStr(s: string, stringToArray: string): string {
    return stringToArray.split(',').filter(x => x != s).join(',');
  }

  addStrtoStr(s: string, stringToArray: string): string {
    return stringToArray + ',' + s;
  }

  findStrInStr(s: string, stringToArray: string): boolean {
    return stringToArray.split(',').some(x => x == s);
  }

  updateArrayItem(newItem: Message, array: Message[]) {
    let updateItem = array.find(x => x.messageId == newItem.messageId);
    let index = array.indexOf(updateItem);
    console.log('update item: ' + JSON.stringify(updateItem) + ' index: ' + index);
    array[index] = newItem;
  }
  removeArrayItem(newItem: Message, array: Message[]) {
    let deleteItem = array.find(x => x.messageId == - newItem.messageId);
    let index = array.indexOf(deleteItem);
    array.splice(index,1);
  }
}
