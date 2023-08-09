package com.example.booking.project.web.controllers;


import com.example.booking.project.models.entities.OccupancyModel;
import com.example.booking.project.services.implementations.ReservationServicempl;
import com.example.booking.project.web.dto.ReservationDTO;
import com.example.booking.project.web.excepction.CustomBadRequestException;
import com.example.booking.project.web.excepction.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import com.example.booking.project.web.excepction.CustomBadRequestException;
import com.example.booking.project.web.excepction.ErrorResponse;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    @Autowired
    private ReservationServicempl reservationService;

    @GetMapping
    public ResponseEntity<ArrayList<ReservationDTO>> getReservation() {
        return new ResponseEntity<>(this.reservationService.getReservation(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> saveReservation(@RequestBody ReservationDTO reservation) {
        return new ResponseEntity<>( this.reservationService.saveReservation(reservation), HttpStatus.OK);
    }

    @GetMapping("/user/{client_id}")
    public ResponseEntity<ArrayList<ReservationDTO>> listReservations(@PathVariable("client_id") Long client_id) {
        return new ResponseEntity<>( this.reservationService.listReservations(client_id), HttpStatus.OK) ;
    }

    @GetMapping("/check-reservation")
    public ResponseEntity<OccupancyModel> getOccupancy(@RequestParam("hotel_id") Long hotel_id, @RequestParam("start_date") String start_date, @RequestParam("end_date") String end_date){
        return new ResponseEntity<>( this.reservationService.getOccupancy(hotel_id, start_date, end_date), HttpStatus.OK);
    }

    @GetMapping(path= "/{reservation_id}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable  Long reservation_id){
        return new ResponseEntity<>( this.reservationService.getReservationById(reservation_id), HttpStatus.OK);
    }

    @PutMapping(path= "/{reservation_id}")
    public ResponseEntity<ReservationDTO> updateReservationById(@RequestBody ReservationDTO request, @PathVariable("reservation_id") Long reservation_id) {
        return new ResponseEntity<>( this.reservationService.updateReservationById(request, reservation_id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{reservation_id}")
    public ResponseEntity<String> deleteReservationById(@PathVariable("reservation_id") Long reservation_id) {
        return new ResponseEntity<>(this.reservationService.deleteReservation(reservation_id), HttpStatus.OK);

    }

    @ExceptionHandler(CustomBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleCustomBadRequestException(CustomBadRequestException ex) {
        return new ErrorResponse(LocalDateTime.now(), ex.getStatus(), ex.getMessage());
    }
}