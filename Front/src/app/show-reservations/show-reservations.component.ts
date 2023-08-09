import { Component } from '@angular/core';
import { ReservationService } from '../services/reservation.service';
import { HotelService } from '../services/hotel.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-show-reservations',  
  templateUrl: './show-reservations.component.html',
  styleUrls: ['./show-reservations.component.css']
})
export class ShowReservationsComponent {
  public reservations: any = [];
  public aux: any;

  constructor(private service: ReservationService, private hotelService: HotelService,private router: Router){
    let client = localStorage.getItem('user');
    if(client){
      this.service.listReservations(client).subscribe((reservation)=>{
      this.aux = reservation;
      console.log(reservation);
      this.aux.map((ans: any)=> {
        this.hotelService.getHotelbyId(ans.hotel_id).subscribe((res: any)=>{
          ans.hotelName = res.hotel_name;
          ans.hotelImg = res.img_url;
          ans.price = res.price;
          this.reservations.push(ans);
          console.log(this.reservations);
        })
      })   
    });}
    if(localStorage.getItem("root") == null){
      if(localStorage.getItem("user") == null){
        this.router.navigate(['/login']);
      }
      else this.router.navigate(['/find-hotel']);
    }
      
  }
  async deleteReservation(id:string){
    try{
      await this.service.deleteReservation(id).toPromise();

    }catch(e){
      console.log(e);
      window.location.reload();
    }
  }

  public getNumberOfDays(start_date: Date, end_date: Date) {
    const startDateObj = new Date(start_date);
    const endDateObj = new Date(end_date);

    const timeDifference = endDateObj.getTime() - startDateObj.getTime();

    const numberOfDays = timeDifference / (1000 * 3600 * 24);

    return Math.round(numberOfDays);
  }

}
