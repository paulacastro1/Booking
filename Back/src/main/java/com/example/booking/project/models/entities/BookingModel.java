package com.example.booking.project.models.entities;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class BookingModel {
    @Column
    private LocalDate end_date;
    @Column LocalDate start_date;
    @Column
    private int reserved_rooms;
    @Column
    private int no_guests;
    @Column
    private Long hotel_id;
    @Column
    private Long client_id;
    @Column
    private Long reservation_id;
}
