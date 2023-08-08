package com.example.booking.project.services.interfaces;

import com.example.booking.project.models.entities.OccupancyModel;
import com.example.booking.project.web.dto.ReservationDTO;

import java.util.ArrayList;

public interface ReservationService {
    public ArrayList<ReservationDTO> getReservation();
    public ReservationDTO saveReservation(ReservationDTO reservation);
    public ArrayList<ReservationDTO> listReservations(Long client_id);
    public OccupancyModel getOccupancy(Long hotel_id, String start_date, String end_date);
    public ReservationDTO getReservationById(Long reservation_id);
    public ReservationDTO updateReservationById(ReservationDTO request, Long reservation_id);
    public Boolean deleteReservation(Long reservation_id);
}
