package com.example.booking.project.repositories;

import com.example.booking.project.models.entities.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDate;


public interface IReservationRepository extends JpaRepository<ReservationModel, Long> {
}
