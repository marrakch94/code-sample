import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Request } from '../models/request'

@Injectable({
  providedIn: 'root'
})

export class RequestService {

  apiUrl = "http://localhost:8082/api/v1/request"
  clientApiUrl = "http://localhost:8082/api/v1/client"
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  constructor(private _http: HttpClient) { }

  fetchAllRequests(){
    return this._http.get( `${ this.apiUrl }/` )
  }

  fetchSingleRequest( _requestId : any ){
    return this._http.get( `${ this.apiUrl }/${ _requestId }` )
  }

  createRequest(_request : Request ){
    return this._http.post( `${ this.apiUrl }/add_request/${ _request.client_id }`, _request, this.httpOptions )
  }

  updateRequest(_requestId : any ,_request : Request ){
    return this._http.post( `${ this.apiUrl }/update/${ _requestId }`, JSON.stringify(_request), this.httpOptions )
  }

  deleteRequest(_requestId : any){
    return this._http.delete( `${ this.apiUrl }/delete/${ _requestId }` )
  }

  getRequestsByClientId( _clientId : any ){
    return this._http.get( `${ this.apiUrl }/requestsByClient/${ _clientId }` )
  }

  getAllClients(){
    return this._http.get( `${ this.clientApiUrl }/` )
  }
}
