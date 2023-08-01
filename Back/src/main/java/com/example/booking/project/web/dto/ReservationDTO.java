package com.example.booking.project.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReservationDTO {

    private Long reservation_id;

    private Long hotel_id;

    private Long client_id;

    private LocalDate start_date;

    private LocalDate end_date;

    private int reserved_rooms;

    private int no_guests;
}
