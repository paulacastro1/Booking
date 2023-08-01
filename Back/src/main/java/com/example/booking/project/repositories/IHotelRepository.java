package com.example.booking.project.repositories;

import com.example.booking.project.models.entities.HotelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.ArrayList;

public interface IHotelRepository extends JpaRepository<HotelModel, Long> {
    @Query(value = "SELECT h.*, \n" +
            "       COALESCE(r.total_reserved_rooms, 0) as total_reserved_rooms, \n" +
            "       COALESCE(r.total_no_guests, 0) as total_no_guests \n" +
            "FROM hotel h \n" +
            "LEFT JOIN (\n" +
            "    SELECT hotel_id, \n" +
            "           SUM(reserved_rooms) as total_reserved_rooms, \n" +
            "           SUM(no_guests) as total_no_guests \n" +
            "    FROM reservations \n" +
            "    WHERE ?1 BETWEEN start_date AND end_date OR ?2 BETWEEN start_date AND end_date \n" +
            "    GROUP BY hotel_id\n" +
            ") r ON h.hotel_id = r.hotel_id \n" +
            "WHERE (h.no_of_rooms - COALESCE(r.total_reserved_rooms, 0)) >= ?3 \n" +
            "  AND (h.max_reservations - COALESCE(r.total_no_guests, 0)) >= ?4 \n" +
            "  AND h.price BETWEEN ?5 AND ?6",
            nativeQuery = true)
    ArrayList<HotelModel> findAvailableHotels(LocalDate start_date, LocalDate end_date, int desired_rooms, int desired_guests, int min_price, int max_price);
}

