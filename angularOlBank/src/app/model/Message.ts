import {Forum} from './Forum';

export class Message {

  messageId!: number;
  userId!: number;
  /**
   * decision to use forum object instead of forumId
   */
  forum!:Forum;
  nbrLike!: number;
  nbrDisLike!: number;
  likingUserList!: string;
  disLikingUserList!: string;
  dateTime!: Date;
  messageTxt!: string;

constructor(userId: number,forum: Forum, messageTxt: string) {
  this.userId=userId;
  this.forum=forum;
  this.nbrLike=0;
  this.nbrDisLike=0;
  this.likingUserList='';
  this.disLikingUserList='';
  this.dateTime= new Date();
  this.messageTxt=messageTxt;
}
}
