package com.example.booking.project.repositories;

import com.example.booking.project.models.entities.ReservationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDate;


public interface IReservationRepository extends JpaRepository<ReservationModel, Long> {
    @Query(value = "SELECT\n" +
            "  COALESCE(\n" +
            "    CASE\n" +
            "      WHEN EXISTS (\n" +
            "        SELECT 1\n" +
            "        FROM reservations r\n" +
            "        WHERE r.client_id = ?6\n" +
            "        AND r.hotel_id = ?5\n" +
            "      ) THEN FALSE\n" +
            "      WHEN EXISTS (\n" +
            "        SELECT 1\n" +
            "        FROM reservations r\n" +
            "        WHERE r.client_id = ?6\n" +
            "        AND r.start_date <= ?4\n" +
            "        AND r.end_date >= ?3\n" +
            "      ) THEN FALSE\n" +
            "      WHEN (\n" +
            "        SELECT h.capacity - COALESCE(SUM(r.reserved_rooms), 0)\n" +
            "        FROM hotel h\n" +
            "        LEFT JOIN reservations r ON h.hotel_id = r.hotel_id\n" +
            "        WHERE h.hotel_id = ?5\n" +
            "        AND r.start_date <= ?4\n" +
            "        AND r.end_date >= ?3\n" +
            "      ) < ?1 THEN FALSE\n" +
            "      WHEN (\n" +
            "        SELECT h.max_reservations - COALESCE(SUM(r.no_guests), 0)\n" +
            "        FROM hotel h\n" +
            "        LEFT JOIN reservations r ON h.hotel_id = r.hotel_id\n" +
            "        WHERE h.hotel_id = ?5\n" +
            "        AND r.start_date <= ?4\n" +
            "        AND r.end_date >= ?3\n" +
            "      ) < ?2 THEN FALSE\n" +
            "      ELSE TRUE\n" +
            "    END,\n" +
            "    FALSE\n" +
            "  ) AS result",
            nativeQuery = true)
    Boolean canBookReservation(int reserved_rooms, int no_guests, LocalDate start_date, LocalDate end_date, Long hotel_id, Long client_id);
}
