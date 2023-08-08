import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private URL = 'http://localhost:4050/client';

  constructor(private http: HttpClient) { }

  public getClients(){
    return this.http.get(`${this.URL}`);
  }
  public getClientbyId(id: string){
    return this.http.get(`${this.URL}/${id}`);
  }
  deleteClient(id: string): Observable<void>{
    return this.http.delete<void>(`${this.URL}/${id}`);
  }

}