import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserDTO } from '../models/UserDTO.model';
import { UserModel } from '../models/User.Model';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  private logged = false;
  private URL = 'http://localhost:4050/client'

  constructor(private http:HttpClient) { }

  async login(username: string, password: string): Promise<boolean> {
    const user = await this.http.get<UserDTO>(`${this.URL}/${username}`).toPromise();
    const correctPassword = user? user.password: "";

    if(password === correctPassword){
      this.logged = true;
      localStorage.setItem('user',username);
      if(username === "10101010"){
        localStorage.setItem('root', "root");
      }
      return true
    } else return false;

  }

  sign_up(data: UserModel){
    console.log(data);
    
    this.http.post<any>(`${this.URL}`, data).subscribe((res) => {
    console.log("You're now signed up. You can login now.")
    })
  }

  isLogged(): boolean{
      return this.logged;
  }

  log_out(): void{
    this.logged = false;
  }
  

}
