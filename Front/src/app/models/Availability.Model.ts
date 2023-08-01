export class AvailabilityModel {
    start_date: Date;
    end_date: Date;
    desired_rooms: number;
    desired_guests: number;
    min_price: number;
    max_price: number;


    constructor()
    {
        this.start_date = new Date;
        this.end_date = new Date;
        this.desired_rooms = 0;
        this.desired_guests = 0;
        this.min_price = 0;
        this.max_price = 0;
    }
}