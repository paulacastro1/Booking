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
  errormessage: string = '';

  constructor(private authService: AuthenticationService, private router: Router){
    
  }

  async onSubmit(): Promise<void>{
    try{
      let res = await this.authService.login(this.username, this.password)
      if(res){
        let root_user = localStorage.getItem('root');
        if (root_user) this.router.navigate(['/hotels']);
        else this.router.navigate(['/find-hotel']);
      }
      
    } catch (e) {
      
      this.errormessage = "Incorrect username or password. Please try again.";
      
    }
  }
}
