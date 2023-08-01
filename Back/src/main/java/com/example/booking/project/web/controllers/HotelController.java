package com.example.booking.project.web.controllers;


import com.example.booking.project.web.dto.AvailabilityDTO;
import com.example.booking.project.web.dto.HotelDTO;
import com.example.booking.project.services.implementations.HotelServicempl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelServicempl hotelService;

    @GetMapping
    public ArrayList<HotelDTO> getHotel() {
        return this.hotelService.getHotel();
    }

    @PostMapping("/availability")
    public ArrayList<HotelDTO> showAvailability(@RequestBody AvailabilityDTO available) {
        return this.hotelService.showAvailability(available);
    }

    @PostMapping
    public HotelDTO saveHotel(@RequestBody HotelDTO hotel) {
        return this.hotelService.saveHotel(hotel);
    }

    @GetMapping(path= "/{hotel_id}")
    public HotelDTO getHotelById(@PathVariable Long hotel_id){
        return this.hotelService.getHotelById(hotel_id);
    }

    @PutMapping(path= "/{hotel_id}")
    public HotelDTO updateHotelById(@RequestBody HotelDTO request, @PathVariable("hotel_id") Long hotel_id) {
        return this.hotelService.updateHotelById(request, hotel_id);
    }

    @DeleteMapping(path = "/{hotel_id}")
    public String deleteHotelById(@PathVariable("hotel_id") Long hotel_id) {
        boolean ok = this.hotelService.deleteHotel(hotel_id);
        if (ok) {
            return ("Hotel " + hotel_id + " deleted.");
        } else {
            return ("Couldn't complete deletion.");
        }
    }
}