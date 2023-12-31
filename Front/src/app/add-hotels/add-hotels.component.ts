import { Component } from '@angular/core';
import { HotelModel } from '../models/Hotel.Model';
import { HotelService } from '../services/hotel.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-hotels',
  templateUrl: './add-hotels.component.html',
  styleUrls: ['./add-hotels.component.css']
})
export class AddHotelsComponent {
  hotel: HotelModel;

  constructor(private hotelService : HotelService, private router: Router){
    this.hotel = new HotelModel();
  }

  async onSubmit(){
    console.log(this.hotel);
    await this.hotelService.saveHotel(this.hotel).toPromise();
    this.router.navigate(["/hotels"])
  }
}
