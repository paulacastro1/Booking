import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {

  constructor(
    private router: Router
  ){}

  isLogged: boolean = this.checkIsLogged();
  isRoot: boolean = this.checkIsRoot();

  checkIsLogged() {
    let username = localStorage.getItem('user');
    if(username) return true;
    else return false;
  }

  checkIsRoot(){
    let root_user = localStorage.getItem('root');
    if (root_user) {
      console.log("es root");
      return true;
    }
    else return false;
  }
  
  log_out(){
    localStorage.removeItem("user");
    localStorage.removeItem("root");
    this.router.navigate(['/']);
  }
}
