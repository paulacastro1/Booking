import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private URL = 'http://localhost:4050';

  constructor(private http: HttpClient) { }

  public getClients(){
    return this.http.get(`${this.URL}/client`);
  }
  public getClientbyId(id: string){
    return this.http.get(`${this.URL}/client/${id}`);
  }

}