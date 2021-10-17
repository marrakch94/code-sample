import { Component, OnInit } from '@angular/core';
import {  Router } from '@angular/router';
import { Request } from '../models/request';
import { RequestService } from '../services/request.service';

@Component({
  selector: 'app-request-create',
  templateUrl: './request-create.component.html',
  styleUrls: ['./request-create.component.scss']
})
export class RequestCreateComponent implements OnInit {

  request : Request = new Request()  ;
  clients : any
  message : boolean = false
  constructor(
    private service : RequestService,
    private router : Router
  ) { }

  ngOnInit(): void {
    this.service.getAllClients().subscribe((data)=>{
      this.clients = data
    })
  }

  submit(request : Request){
    this.service.createRequest(request).subscribe((data)=>{
      this.router.navigate(['/request/list']);
    })
  }

  goBack(){
    this.router.navigate(['/request/list']);
  }

}
