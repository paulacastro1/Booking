import { Component } from '@angular/core';
import { HotelModel } from '../models/Hotel.Model';
import { HotelService } from '../services/hotel.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-hotel',
  templateUrl: './edit-hotel.component.html',
  styleUrls: ['./edit-hotel.component.css']
})
export class EditHotelComponent {
  hotel: any;

  constructor(
    private hotelService: HotelService,
    private router: Router,
    private route: ActivatedRoute
  ) {
    let id = this.route.snapshot.paramMap.get("id");
    
    this.hotelService.getHotelbyId(id? id:'').subscribe((res) => {
      this.hotel = res;
    });
  }

  onSubmit(): void {
    this.hotelService.saveHotel(this.hotel);      
    console.log('Hotel edited successfully.');
    this.router.navigate(['/hotels']);
  }
}
