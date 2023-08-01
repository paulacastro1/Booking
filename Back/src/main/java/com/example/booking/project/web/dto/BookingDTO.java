package com.example.booking.project.web.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookingDTO {
    public LocalDate end_date;
    public LocalDate start_date;
    public int reserved_rooms;
    public int no_guests;
    public Long hotel_id;
    public Long client_id;
    public Long reservation_id;
}
