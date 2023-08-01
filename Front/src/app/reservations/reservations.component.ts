import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReservationService } from '../services/reservation.service';
import { ReservationModel } from '../models/Reservation.Model';
import { HotelService } from '../services/hotel.service';
import { BookingModel } from '../models/Booking.Model';
import { ClientService } from '../services/client.service';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent  {
  reservation: ReservationModel;
  clientName: string | undefined;
  hotelName: string | undefined;
  constructor(private router: Router, private service: ReservationService, private route: ActivatedRoute, private hotelService: HotelService, private clientService: ClientService) { 
    this.reservation = new ReservationModel;
    let id = localStorage.getItem('user');
    this.reservation.client_id = Number(id);
    this.clientService.getClientbyId(id? id: '').subscribe((res: any)=> {
      this.clientName = res.client_name;
    })
    this.route.queryParams.subscribe((e:any)=> {
      let h_id = this.reservation.hotel_id = e.hotel_id;
      this.hotelService.getHotelbyId(h_id? h_id: '').subscribe((ans: any)=> {
        this.hotelName = ans.hotel_name;
      })
      this.reservation.start_date = e.start_date;
      this.reservation.end_date = e.end_date;
      this.reservation.reserved_rooms = e.reserved_rooms;
      this.reservation.no_guests = e.no_guests;
      console.log(e);
    });
    
    console.log(this.reservation);
    
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.service.saveReservation(this.reservation); 
    console.log(this.reservation     )
    console.log('Reservation saved successfully.');
    this.router.navigate(['/show-reservations']);
  }
}
