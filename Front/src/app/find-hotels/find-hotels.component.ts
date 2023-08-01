import { Component } from '@angular/core';
import { HotelService } from '../services/hotel.service';
import { AvailabilityModel } from '../models/Availability.Model';
import { Router } from '@angular/router';

@Component({
  selector: 'app-find-hotels',
  templateUrl: './find-hotels.component.html',
  styleUrls: ['./find-hotels.component.css']
})
export class FindHotelsComponent {
  public hotels: any;
  availability: AvailabilityModel;
  selectedPriceRange: string;

  constructor(private service: HotelService, private router: Router){
    this.availability = new AvailabilityModel;
    this.selectedPriceRange = '';
    this.getHotels();
  }
    


  ngOnInit(): void{}
  onSubmit(): void{

    const [minPrice, maxPrice] = this.selectedPriceRange.split('-');
    this.availability.min_price = parseInt(minPrice, 10);
    this.availability.max_price = parseInt(maxPrice, 10);
  
    console.log(this.availability);
    console.log(this.availability);
    this.service.getAvailability(this.availability).subscribe((res) => {
      this.hotels = res;
      console.log(this.hotels);
    });
    
  }

  private getHotels() {
    this.service.getHotels().subscribe((hotel) => {
      this.hotels = hotel;
      console.log(this.hotels);
    });
  }
  
  
  
}
