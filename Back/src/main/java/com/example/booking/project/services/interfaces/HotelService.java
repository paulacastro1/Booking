package com.example.booking.project.services.interfaces;

import com.example.booking.project.web.dto.AvailabilityDTO;
import com.example.booking.project.web.dto.HotelDTO;

import java.util.ArrayList;

public interface HotelService {
    public ArrayList<HotelDTO> getHotel();
    public HotelDTO saveHotel(HotelDTO hotel);
    public ArrayList<HotelDTO> showAvailability(AvailabilityDTO available);
    public HotelDTO getHotelById(Long hotel_id);
    public HotelDTO updateHotelById(HotelDTO request, Long hotel_id);
    public String deleteHotel(Long hotel_id);
}
