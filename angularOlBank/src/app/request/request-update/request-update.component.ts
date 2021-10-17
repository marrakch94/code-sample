import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Request } from '../models/request';
import { RequestService } from '../services/request.service';

@Component({
  selector: 'app-request-update',
  templateUrl: './request-update.component.html',
  styleUrls: ['./request-update.component.scss']
})
export class RequestUpdateComponent implements OnInit {

  request : Request = new Request()  ;
  message : boolean = false
  constructor(
    private service : RequestService,
    private route: ActivatedRoute,
    private router : Router
  ) { }

  ngOnInit(): void {
    this.service.fetchSingleRequest( this.route.snapshot.params['id'] ).subscribe((data: any)=>{
      this.request = data
    })
  }

  goBack(){
    this.router.navigate(['/request/list']);
  }

  submit(request : Request){
    this.service.updateRequest(request.id,  request).subscribe((data)=>{
      this.router.navigate(['/request/list']);
    })
  }

}
