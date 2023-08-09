package com.example.booking.project.web.controllers;


import com.example.booking.project.web.dto.AvailabilityDTO;
import com.example.booking.project.web.dto.HotelDTO;
import com.example.booking.project.services.implementations.HotelServicempl;
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
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelServicempl hotelService;

    @GetMapping
    public ResponseEntity<ArrayList<HotelDTO>> getHotel() {
        return new ResponseEntity<>( this.hotelService.getHotel(), HttpStatus.OK);
    }

    @PostMapping("/availability")
    public ResponseEntity<ArrayList<HotelDTO>> showAvailability(@RequestBody AvailabilityDTO available) {
        return new ResponseEntity<>( this.hotelService.showAvailability(available), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HotelDTO> saveHotel(@RequestBody HotelDTO hotel) {
        return new ResponseEntity<>( this.hotelService.saveHotel(hotel), HttpStatus.OK);
    }

    @GetMapping(path= "/{hotel_id}")
    public ResponseEntity<HotelDTO> getHotelById(@PathVariable Long hotel_id){
        return new ResponseEntity<>( this.hotelService.getHotelById(hotel_id), HttpStatus.OK);
    }

    @PutMapping(path= "/{hotel_id}")
    public ResponseEntity<HotelDTO> updateHotelById(@RequestBody HotelDTO request, @PathVariable("hotel_id") Long hotel_id) {
        return new ResponseEntity<>(this.hotelService.updateHotelById(request, hotel_id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{hotel_id}")
    public ResponseEntity<String> deleteHotelById(@PathVariable("hotel_id") Long hotel_id) {
        return new ResponseEntity<>(this.hotelService.deleteHotel(hotel_id), HttpStatus.OK);
    }

    @ExceptionHandler(CustomBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleCustomBadRequestException(CustomBadRequestException ex) {
        return new ErrorResponse(LocalDateTime.now(), ex.getStatus(), ex.getMessage());
    }

}