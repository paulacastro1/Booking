package com.example.booking.project.models.entities;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class AvailabilityModel {
    @Column
    private LocalDate start_date;
    @Column
    private LocalDate end_date;
    @Column
    private int desired_rooms;
    @Column
    private int desired_guests;
    @Column
    private int min_price;
    @Column
    private int max_price;
}
