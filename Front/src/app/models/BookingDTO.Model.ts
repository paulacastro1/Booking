export interface BookingDTO {
    end_date: Date,
    start_date: Date,
    reserved_rooms: number,
    no_guests: number,
    hotel_id: number,
    client_id: number,
    reservation_id: number
}