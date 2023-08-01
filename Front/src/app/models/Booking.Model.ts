export class BookingModel {
    end_date: Date;
    start_date: Date;
    reserved_rooms: number;
    no_guests: number;
    hotel_id: number;
    client_id: number;
    reservation_id: number;


    constructor()
    {
        this.end_date = new Date;
        this.start_date = new Date;
        this.reserved_rooms = 0;
        this.no_guests = 0;
        this.hotel_id = 0;
        this.client_id = 0;
        this.reservation_id = 0;
    }
}