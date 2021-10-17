import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RequestService } from '../services/request.service';

@Component({
  selector: 'app-request-list',
  templateUrl: './request-list.component.html',
  styleUrls: ['./request-list.component.scss']
})
export class RequestListComponent implements OnInit {

  data : any
  constructor(
    private service : RequestService,
    private route : ActivatedRoute
  ) { }

  ngOnInit(): void {
    if( this.route.snapshot.params['id'] != undefined  ){
      this.service.getRequestsByClientId( this.route.snapshot.params['id'] ).subscribe((data:any)=>{
        this.data = data
      })
    }else{
      this.service.fetchAllRequests().subscribe((data:any)=>{
        this.data = data
      })
    }

  }

  changeRequestState(_requestId : any){

  }

  deleteRequest(event:any, object_id:number){
    this.service.deleteRequest(object_id).subscribe((data:any)=>{
      event.target.parentElement.parentElement.remove()
    })
  }
}
