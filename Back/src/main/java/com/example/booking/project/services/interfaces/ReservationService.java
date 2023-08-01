package com.example.booking.project.services.interfaces;

import com.example.booking.project.web.dto.BookingDTO;
import com.example.booking.project.web.dto.ReservationDTO;

import java.util.ArrayList;

public interface ReservationService {
    public ArrayList<ReservationDTO> getReservation();
    public Boolean checkReservation(BookingDTO booking);
    public ReservationDTO saveReservation(ReservationDTO reservation);
    public ReservationDTO getReservationById(Long reservation_id);
    public ReservationDTO updateReservationById(ReservationDTO request, Long reservation_id);
    public Boolean deleteReservation(Long reservation_id);
}