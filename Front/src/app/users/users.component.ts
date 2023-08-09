import { Component } from '@angular/core';
import { ClientService } from '../services/client.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent {

  public users: any;
  constructor(private service: ClientService,private router: Router){
    this.service.getClients().subscribe((user)=>{
      this.users = user;
    })
    if(localStorage.getItem("root") == null){
      if(localStorage.getItem("user") == null){
        this.router.navigate(['/login']);
      }
      else this.router.navigate(['/find-hotel']);
    }
  }
  
  async deleteUser(id:string){
    this.service.deleteClient(id).subscribe(
      () => {
        console.log('Client deleted successfully.');
        window.location.reload();
      },
      (error) => {
        console.error('Error deleting client:', error);
      }
    );
  }
  
}
