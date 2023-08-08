package com.example.booking.project.services.implementations;

import com.example.booking.project.models.entities.OccupancyModel;
import com.example.booking.project.models.entities.ReservationModel;
import com.example.booking.project.repositories.IReservationRepository;
import com.example.booking.project.services.interfaces.ReservationService;
import com.example.booking.project.web.dto.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ReservationServicempl implements ReservationService {
    @Autowired
    private IReservationRepository reservationRepository;

    public ReservationModel MapDTOtoModel(ReservationDTO reservation) {
        ReservationModel reservationModel = ReservationModel.builder()
                .reservation_id(reservation.getReservation_id())
                .hotel_id(reservation.getHotel_id())
                .client_id(reservation.getClient_id())
                .start_date(reservation.getStart_date())
                .end_date(reservation.getEnd_date())
                .reserved_rooms(reservation.getReserved_rooms())
                .no_guests(reservation.getNo_guests())
                .build();
        return reservationModel;
    }

    public ReservationDTO MapModeltoDTO(ReservationModel reservation) {
        ReservationDTO reservationDTO = ReservationDTO.builder()
                .reservation_id(reservation.getReservation_id())
                .hotel_id(reservation.getHotel_id())
                .client_id(reservation.getClient_id())
                .start_date(reservation.getStart_date())
                .end_date(reservation.getEnd_date())
                .reserved_rooms(reservation.getReserved_rooms())
                .no_guests(reservation.getNo_guests())
                .build();
        return reservationDTO;
    }
    public ArrayList<ReservationDTO> listReservations(Long client_id){
        ArrayList<ReservationModel> bookingsModel = reservationRepository.showReservations(client_id);
        ArrayList<ReservationDTO> bookingsDTO = new ArrayList<>();
        for(int i=0; i< bookingsModel.size(); i++){
            bookingsDTO.add(this.MapModeltoDTO(bookingsModel.get(i)));
        }
        return bookingsDTO;

    }
    public OccupancyModel getOccupancy(Long hotel_id, String start_date, String end_date) {
        ArrayList<Object[]> resp = reservationRepository.sumOccupancy(hotel_id, start_date, end_date);




        Object[] row = resp.get(0);
        Integer hotelId = (Integer) row[0];
        BigDecimal Rooms = (BigDecimal) row[1];
        BigDecimal Guests = (BigDecimal) row[2];

        if(hotelId == null){
            return OccupancyModel.builder()
                    .hotel_id(hotel_id)
                    .rooms(0L)
                    .guests(0L)
                    .build();
        }

        return OccupancyModel.builder()
                .hotel_id(hotelId.longValue())
                .rooms(Rooms.longValue())
                .guests(Guests.longValue())
                .build();
    }

    @Override
    public ArrayList<ReservationDTO> getReservation(){
        ArrayList<ReservationModel> reservations = (ArrayList<ReservationModel>)  reservationRepository.findAll();
        ArrayList<ReservationDTO> show_reservations = new ArrayList<ReservationDTO>();
        for(int i=0; i< reservations.size(); i++){
            show_reservations.add(this.MapModeltoDTO(reservations.get(i)));
        }
        return show_reservations;
    }
    @Override
    public ReservationDTO saveReservation(ReservationDTO reservation){
        ReservationModel reservationModel = this.MapDTOtoModel(reservation);
        ReservationDTO reservationDTO = this.MapModeltoDTO(reservationRepository.save(reservationModel));
        return reservationDTO;
    }

    @Override
    public ReservationDTO getReservationById(Long reservation_id){
        Optional<ReservationModel> query = reservationRepository.findById(reservation_id);
        ReservationDTO reservation = this.MapModeltoDTO(query.get());
        return reservation;
    }

    @Override
    public ReservationDTO updateReservationById(ReservationDTO request, Long reservation_id){
        ReservationModel reservation = reservationRepository.findById(reservation_id).get();

        reservation.setStart_date(request.getStart_date());
        reservation.setStart_date(request.getEnd_date());
        reservation.setReserved_rooms(request.getReserved_rooms());
        reservation.setNo_guests(request.getNo_guests());

        ReservationDTO reservationDTO = this.MapModeltoDTO(reservationRepository.save(reservation));

        return reservationDTO;
    }

    @Override
    public Boolean deleteReservation(Long reservation_id){
        try {
            System.out.println(("reserva eliminada"));
            reservationRepository.deleteById(reservation_id);
            return true;
        }catch(Exception e){
            System.out.println(e);
            System.out.println("no se puede borrar reserva");
            return false;
        }

    }
}


