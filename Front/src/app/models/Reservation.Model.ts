export class ReservationModel{
    reservation_id: number;
    hotel_id: number;
    client_id: number;
    start_date: Date;
    end_date: Date;
    reserved_rooms: number;
    no_guests: number;



    constructor()
    {
        this.reservation_id = 0;
        this.hotel_id = 0 ;
        this.client_id = 0 ;
        this.start_date = new Date;
        this.end_date = new Date;
        this.reserved_rooms = 0;
        this.no_guests = 0;
    }
    
}