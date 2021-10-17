import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { RequestService } from '../services/request.service';

@Component({
  selector: 'app-request-detail',
  templateUrl: './request-detail.component.html',
  styleUrls: ['./request-detail.component.scss']
})
export class RequestDetailComponent implements OnInit {

  data : any;

  constructor(
    private service : RequestService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.service.fetchSingleRequest( this.route.snapshot.params['id'] ).subscribe((data)=>{
      this.data  = data
    })
  }

}
