export class HotelModel {
    hotel_id: number;
    hotel_name: string;
    max_reservations: number;
    phone_number: string;
    email: string;
    capacity: number;
    img_url: string;
    price: number;

    constructor()
    {
        this.hotel_id = 0;
        this.hotel_name = '';
        this.max_reservations = 0;
        this.phone_number = '';
        this.email = '';
        this.capacity = 0
        this.img_url = '';
        this.price = 0;
    }
}