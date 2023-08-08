import { Component } from '@angular/core';
import { ClientService } from '../services/client.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent {

  public users: any;
  constructor(private service: ClientService){
    this.service.getClients().subscribe((user)=>{
      this.users = user;
    })
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
