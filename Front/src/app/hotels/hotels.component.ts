import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HotelService } from 'src/app/services/hotel.service'

@Component({
  selector: 'app-hotels',
  templateUrl: './hotels.component.html',
  styleUrls: ['./hotels.component.css']
})
export class HotelsComponent {
  public hotels: any;

  constructor(
    private service: HotelService,
    private router: Router
    ){
    this.service.getHotels().subscribe((hotel)=>{
      this.hotels = hotel;
      console.log(this.hotels);
    });
    
  }
  public deleteHotelById(id: string) {
    this.service.deleteHotelById(id).subscribe(
      () => {
        console.log('Hotel deleted successfully.');
        window.location.reload();
      },
      (error) => {
        console.error('Error deleting hotel:', error);
      }
    );
  }
  ngOnInit(): void{}
}
