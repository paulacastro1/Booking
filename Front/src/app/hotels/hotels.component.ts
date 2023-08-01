import { Component } from '@angular/core';
import { HotelService } from 'src/app/services/hotel.service'

@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrls: ['./hotels.component.css']
})
export class HotelsComponent {
  public hotels: any;

  constructor(private service: HotelService){
    this.service.getHotels().subscribe((hotel)=>{
      this.hotels = hotel;
      console.log(this.hotels);
    });
  }
  ngOnInit(): void{}
}
