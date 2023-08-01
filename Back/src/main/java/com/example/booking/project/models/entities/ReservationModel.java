package com.example.booking.project.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Reservations")

public class ReservationModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservation_id;

    @Column
    private Long hotel_id;

    @Column
    private Long client_id;

    @Column
    private LocalDate start_date;

    @Column
    private LocalDate end_date;

    @Column
    private int reserved_rooms;

    @Column
    private int no_guests;


}
