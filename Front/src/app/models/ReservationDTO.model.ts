export interface ReservationDTO{
    reservation_id: number;
    hotel_id: number;
    client_id: number;
    start_date: Date;
    end_date: Date;
    reserved_rooms: number;
    no_guests: number;

}

