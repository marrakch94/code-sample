export class Forum {
  constructor(forumId: number) {
    this.forumId = forumId;
  }

  forumId!:number;
  topic!:string;
  forumDate!:Date;
}
