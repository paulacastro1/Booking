import {HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { HotelModel } from '../models/Hotel.Model';
import { AvailabilityModel } from '../models/Availability.Model';

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
    console.log(data);
    
    this.http.post<any>(`${this.URL}/hotel`, data).subscribe((res) => {
    console.log("Hotel created.")
    })
  }
  public deleteHotelById(id: string){
    return this.http.delete(`${this.URL}/hotel/${id}`);
  }
  public updateHotel(data: HotelModel) {
    console.log(data);

    this.http.put<any>(`${this.URL}/hotel/${data.hotel_id}`, data).subscribe((res) => {
      console.log("Hotel updated.");
    });
  }
  public getAvailability(data: AvailabilityModel){
    console.log(data);
    
    return this.http.post<any>(`${this.URL}/hotel/availability`, data);
  }
}