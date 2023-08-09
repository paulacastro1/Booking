import { Component } from '@angular/core';
import { AuthenticationService } from '../services/authentication.service';
import { UserModel } from '../models/User.Model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  user: UserModel;

  constructor(private authService: AuthenticationService, private router: Router){
    this.user = new UserModel();
    if(localStorage.getItem("root") == null){
      if(localStorage.getItem("user") == null){
        this.router.navigate(['/login']);
      }
      else this.router.navigate(['/find-hotel']);
    }
    else this.router.navigate(['/hotels']);
  }

  onSubmit(): void{
    console.log(this.user);
    this.authService.sign_up(this.user);
    localStorage.setItem('user',this.user.client_id.toString());
    this.router.navigate(['/find-hotel']);
  }

}
