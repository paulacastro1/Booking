package com.example.booking.project.web.controllers;


import com.example.booking.project.services.implementations.ReservationServicempl;
import com.example.booking.project.web.dto.BookingDTO;
import com.example.booking.project.web.dto.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/reservation")
public class ReservationController  {

    @Autowired
    private ReservationServicempl reservationService;

    @GetMapping
    public ArrayList<ReservationDTO> getReservation() {
        return this.reservationService.getReservation();
    }

    @PostMapping
    public ReservationDTO saveReservation(@RequestBody ReservationDTO reservation) {
        return this.reservationService.saveReservation(reservation);
    }

    @GetMapping(path= "/{reservation_id}")
    public ReservationDTO getReservationById(@PathVariable Long reservation_id){
        return this.reservationService.getReservationById(reservation_id);
    }

    @PutMapping(path= "/{reservation_id}")
    public ReservationDTO updateReservationById(@RequestBody ReservationDTO request, @PathVariable("reservation_id") Long reservation_id) {
        return this.reservationService.updateReservationById(request, reservation_id);
    }

    @DeleteMapping(path = "/{reservation_id}")
    public String deleteReservationById(@PathVariable("reservation_id") Long reservation_id) {
        boolean ok = this.reservationService.deleteReservation(reservation_id);
        if (ok) {
            return ("Reservation " + reservation_id + " deleted.");
        } else {
            return ("Couldn't complete deletion.");
        }
    }
}