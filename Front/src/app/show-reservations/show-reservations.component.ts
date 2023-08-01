import { Component } from '@angular/core';
import { ReservationService } from '../services/reservation.service';
import { HotelService } from '../services/hotel.service';

@Component({
  selector: 'app-show-reservations',
  templateUrl: './show-reservations.component.html',
  styleUrls: ['./show-reservations.component.css']
})
export class ShowReservationsComponent {
  public reservations: any = [];
  public aux: any;

  constructor(private service: ReservationService, private hotelService: HotelService){
    this.service.getReservations().subscribe((reservation)=>{
      this.aux = reservation;
      console.log(reservation);
      this.aux.map((ans: any)=> {
        this.hotelService.getHotelbyId(ans.hotel_id).subscribe((res: any)=>{
          ans.hotelName = res.hotel_name;
          ans.hotelImg = res.img_url;
          this.reservations.push(ans);
          console.log(this.reservations);
        })
      })
      
      
      
    });
  }
  ngOnInit(): void{}

}
