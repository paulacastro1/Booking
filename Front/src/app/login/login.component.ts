import { Component, } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
 
  username: string = ''; 
  password: string = '';

  constructor(private authService: AuthenticationService, private router: Router){}

  async onSubmit(): Promise<void>{
    console.log("hola");
    if(await this.authService.login(this.username, this.password)){
      console.log("You're logged in.")
      let root_user = localStorage.getItem('root');
      if (root_user) this.router.navigate(['/hotels']);
      else this.router.navigate(['/find-hotel']);
    }
    else{
      alert("Incorrect username or password. Please try again.")
    }
  }
}
