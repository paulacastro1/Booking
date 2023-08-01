import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReservationService } from '../services/reservation.service';
import { ReservationModel } from '../models/Reservation.Model';
import { HotelService } from '../services/hotel.service';
import { BookingModel } from '../models/Booking.Model';

@Component({
  selector: 'app-reservations',
  templateUrl: './reservations.component.html',
  styleUrls: ['./reservations.component.css']
})
export class ReservationsComponent  {
  reservation: ReservationModel;
  booking: BookingModel;
  constructor(private router: Router, private service: ReservationService, private route: ActivatedRoute, private hotelService: HotelService) { 
    this.reservation = new ReservationModel;
    this.booking = new BookingModel;
    this.reservation.client_id = Number(localStorage.getItem('user'));
    this.route.queryParams.subscribe((e:any)=> {
      this.reservation.hotel_id = Number(e.hotel_id);
      this.reservation.start_date = e.start_date;
      this.reservation.end_date = e.end_date;
      console.log(e);
    });
    this.reservation.reserved_rooms= Number(localStorage.getItem('desired_rooms'));
    this.reservation.no_guests = Number(localStorage.getItem('desired_guests'));
    
    this.booking.end_date = this.reservation.end_date;
    this.booking.start_date = this.reservation.start_date;
    this.booking.reserved_rooms = this.reservation.reserved_rooms;
    this.booking.no_guests = this.reservation.no_guests;
    this.booking.client_id = this.reservation.client_id;
    this.booking.hotel_id = this.reservation.hotel_id;
    this.booking.reservation_id = this.reservation.reservation_id;
    console.log(this.booking);
    console.log(this.reservation);
    
  }

  ngOnInit(): void {
  }

  onSubmit(): void {
    this.service.checkReservation(this.booking);
    this.service.saveReservation(this.reservation);      
    console.log('Reservation saved successfully.');
    this.router.navigate(['/show-reservations']);
  }
}
