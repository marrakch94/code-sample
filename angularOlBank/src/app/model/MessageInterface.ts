import {Forum} from './Forum';

export interface MessageInterface {
  messageId: number;
  userId: number;
  //forumForumId!:number;
  forum:Forum;
  nbrLike: number;
  nbrDisLike: number;
  likingUserList: string;
  disLikingUserList: string;
  dateTime: Date;
  messageTxt: string;



}
