import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ReservationModel } from '../models/Reservation.Model';
import { BookingModel } from '../models/Booking.Model';

@Injectable({
  providedIn: 'root'
})
export class ReservationService {
  private URL = 'http://localhost:4050/reservation';

  constructor(private http: HttpClient) { }

  public getReservations(){
    return this.http.get(`${this.URL}`);
  }
  public checkReservation(data: BookingModel){
    console.log("data:");
    console.log(data);
    this.http.post<any>(`${this.URL}/check-reservation`, data).subscribe((res) => {
      console.log(res)
    })
  }
  public deleteReservation(id: string){
    console.log(`${this.URL}/${id}`);
    return this.http.delete(`${this.URL}/${id}`);
  }
  
  public saveReservation(data: ReservationModel){
    console.log(data);
    this.http.post<any>(`${this.URL}`, data).subscribe((res) => {
      console.log("Booked succesfully.")
    })
  }

}