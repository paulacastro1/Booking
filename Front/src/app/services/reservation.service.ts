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
  
  public deleteReservation(id: string): Observable<void>{
    return this.http.delete<any>(`${this.URL}/${id}`);
  }
  
  public saveReservation(data: ReservationModel){
    console.log(data);
    this.http.post<any>(`${this.URL}`, data).subscribe((res) => {
      console.log("Booked succesfully.")
    })
  }

  public checkReservation(hotel_id: number, start_date: Date, end_date: Date){
    return this.http.get(`${this.URL}/check-reservation?hotel_id=${hotel_id}&start_date=${start_date}&end_date=${end_date}`);
  }
  
  public listReservations(client_id: string ){
    return this.http.get(`${this.URL}/user/${client_id}`);
  }

}