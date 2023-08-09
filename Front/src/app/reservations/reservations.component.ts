import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReservationService } from '../services/reservation.service';
import { ReservationModel } from '../models/Reservation.Model';
import { HotelService } from '../services/hotel.service';
import { ClientService } from '../services/client.service';
import { HotelModel } from '../models/Hotel.Model';
import { filter, map } from 'rxjs/operators';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent  {
  reservation: ReservationModel;
  hotel: HotelModel;
  clientName: string | undefined;
  hotelName: string | undefined;
  flag: string | undefined;
  constructor(private router: Router, private service: ReservationService, private route: ActivatedRoute, private hotelService: HotelService, private clientService: ClientService) { 
    if(localStorage.getItem("root") == null){
      if(localStorage.getItem("user") == null){
        this.router.navigate(['/login']);
      }
      else this.router.navigate(['/find-hotel']);
    }
    
    this.reservation = new ReservationModel;
    this.hotel = new HotelModel;
    let id = localStorage.getItem('user');
    this.reservation.client_id = Number(id);
    this.clientService.getClientbyId(id? id: '').subscribe((res: any)=> {
      this.clientName = res.client_name;
    })
    this.route.queryParams.subscribe((e:any)=> {
      let h_id = this.reservation.hotel_id = e.hotel_id;
      this.hotel.hotel_id = h_id;
      this.hotelService.getHotelbyId(h_id? h_id: '').subscribe((ans: any)=> {
        this.hotelName = ans.hotel_name;
        this.hotel.max_reservations = ans.max_reservations;
        this.hotel.capacity = ans.capacity;
      })
      this.reservation.start_date = e.start_date;
      this.reservation.end_date = e.end_date;
      this.reservation.reserved_rooms = e.reserved_rooms;
      this.reservation.no_guests = e.no_guests;
      console.log(e);
    });
    
    console.log(this.reservation);
    
  }
  aproveReservation(hotel_id: number, start_date: Date, end_date: Date): boolean {
    

    return true;
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    console.log(this.hotel.hotel_id, this.reservation.start_date, this.reservation.end_date);
    this.service.checkReservation(this.hotel.hotel_id, this.reservation.start_date, this.reservation.end_date).subscribe((resp: any) => {
      // console.log("reserved rooms: ", this.reservation.reserved_rooms, "number of guests: ", this.reservation.no_guests, "hotel rooms: ", this.hotel.capacity, "can hosts guests: ", this.hotel.max_reservations - resp.guests);
      if((this.hotel.capacity - resp.rooms >= this.reservation.reserved_rooms) && (this.hotel.max_reservations - resp.guests >= this.reservation.no_guests)){
        this.service.saveReservation(this.reservation); 
        console.log(this.reservation     )
        console.log('Reservation saved successfully.');
        this.router.navigate(['/show-reservations']);
        this.flag = "The hotel good";
      }
      else {
        console.log("couldn't save");
        this.flag = "The hotel can't host as many guests or doesn't have enough rooms.";
    }
    });
    

  }
}