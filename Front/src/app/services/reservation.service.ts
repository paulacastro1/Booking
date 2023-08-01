import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ReservationModel } from '../models/Reservation.Model';
import { BookingModel } from '../models/Booking.Model';
import { Observable } from 'rxjs';

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
  public deleteReservation(id: string): Observable<void>{
    return this.http.delete<void>(`${this.URL}/${id}`);
  }
  
  public saveReservation(data: ReservationModel){
    console.log(data);
    this.http.post<any>(`${this.URL}`, data).subscribe((res) => {
      console.log("Booked succesfully.")
    })
  }
  public listReservations(client_id: string ){
    return this.http.get(`${this.URL}/user/${client_id}`);
  }

}