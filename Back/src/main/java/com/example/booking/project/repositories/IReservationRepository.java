package com.example.booking.project.repositories;

import com.example.booking.project.models.entities.HotelModel;
import com.example.booking.project.models.entities.ReservationModel;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDate;
import java.util.ArrayList;


public interface IReservationRepository extends JpaRepository<ReservationModel, Long> {
    @Query(value = "SELECT * FROM reservations WHERE client_id = ?1",
            nativeQuery = true)
    ArrayList<ReservationModel> showReservations(Long client_id);

    @Query(value = "select hotel_id, sum(reserved_rooms) as total_rooms, " +
            "sum(no_guests) as total_guests from reservations where " +
            "hotel_id = ?1 and ((?3 <=  start_date and ?2 >= end_date) " +
            "or (?3 >=  start_date and ?2 <= end_date) " +
            "or (?2 <= end_date and ?2 >= start_date) " +
            "or (?3 <= end_date and ?3 >= start_date))",
            nativeQuery = true)
    ArrayList<Object[]> sumOccupancy(Long hotel_id, String end_date, String start_date);

}

