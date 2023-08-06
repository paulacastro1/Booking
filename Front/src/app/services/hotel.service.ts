import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HotelModel } from '../models/Hotel.Model';
import { AvailabilityModel } from '../models/Availability.Model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HotelService {
  private URL = 'http://localhost:4050';

  constructor(private http: HttpClient) { }

  public getHotels(){
    return this.http.get(`${this.URL}/hotel`);
  }
  
  public getHotelbyId(id: string){
    return this.http.get(`${this.URL}/hotel/${id}`);
  }
  
  public saveHotel(data: HotelModel){
    return this.http.post<any>(`${this.URL}/hotel`, data);
  }

  deleteHotelById(id: string): Observable<void> {
    return this.http.delete<void>(`${this.URL}/hotel/${id}`);
  }

  public updateHotel(data: HotelModel) {
    return this.http.put<any>(`${this.URL}/hotel/${data.hotel_id}`, data);
  }

  public getAvailability(data: AvailabilityModel){
    return this.http.post<any>(`${this.URL}/hotel/availability`, data);
  }
}