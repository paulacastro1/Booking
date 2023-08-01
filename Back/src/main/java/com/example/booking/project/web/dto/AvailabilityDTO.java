package com.example.booking.project.web.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AvailabilityDTO {
    private LocalDate start_date;
    private LocalDate end_date;
    private int desired_rooms;
    private int desired_guests;
    private int min_price;
    private int max_price;
}
