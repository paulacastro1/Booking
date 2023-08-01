package com.example.booking.project.repositories;

import com.example.booking.project.models.entities.HotelModel;
import com.example.booking.project.models.entities.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDate;
import java.util.ArrayList;


public interface IReservationRepository extends JpaRepository<ReservationModel, Long> {
    @Query(value = "SELECT * FROM reservations WHERE client_id = ?1",
            nativeQuery = true)
    ArrayList<ReservationModel> showReservations(Long client_id);
}

