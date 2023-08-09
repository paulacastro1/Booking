package com.example.booking.project.services.implementations;


import com.example.booking.project.models.entities.AvailabilityModel;
import com.example.booking.project.models.entities.HotelModel;
import com.example.booking.project.web.dto.AvailabilityDTO;
import com.example.booking.project.web.dto.HotelDTO;
import com.example.booking.project.repositories.IHotelRepository;
import com.example.booking.project.services.interfaces.HotelService;
import com.example.booking.project.web.excepction.CustomBadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class HotelServicempl implements HotelService {
    @Autowired
    private IHotelRepository hotelRepository;

    public HotelModel MapDTOtoModel(HotelDTO hotel){
        HotelModel hotelModel = HotelModel.builder().
                hotel_id(hotel.getHotel_id())
                .hotel_name(hotel.getHotel_name())
                .max_reservations(hotel.getMax_reservations())
                .phone_number(String.valueOf(hotel.getMax_reservations()))
                .email(hotel.getEmail())
                .capacity(hotel.getCapacity())
                .img_url(hotel.getImg_url())
                .price(hotel.getPrice())
                .build();
        return hotelModel;
    }
    public HotelDTO MapModeltoDTO(HotelModel hotel){
        HotelDTO hotelDTO = HotelDTO.builder()
                .hotel_id(hotel.getHotel_id())
                .hotel_name(hotel.getHotel_name())
                .max_reservations(hotel.getMax_reservations())
                .phone_number(String.valueOf(hotel.getMax_reservations()))
                .email(hotel.getEmail())
                .capacity(hotel.getCapacity())
                .img_url(hotel.getImg_url())
                .price(hotel.getPrice())
                .build();
        return hotelDTO;
    }

    @Override
    public ArrayList<HotelDTO> showAvailability(AvailabilityDTO available) {
        try{
            ArrayList<HotelModel> availableHotelModel = hotelRepository.findAvailableHotels(available.getStart_date(), available.getEnd_date(), available.getDesired_rooms(), available.getDesired_guests(), available.getMin_price(), available.getMax_price());
            ArrayList<HotelDTO> availableHotelDTO = new ArrayList<>();
            for(int i=0; i< availableHotelModel.size(); i++){
                availableHotelDTO.add(this.MapModeltoDTO(availableHotelModel.get(i)));
            }
            return availableHotelDTO;
        } catch(Exception e){
            throw new CustomBadRequestException("Error, intentelo mas tarde.", HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public ArrayList<HotelDTO> getHotel(){
        ArrayList<HotelModel> hotels = (ArrayList<HotelModel>)  hotelRepository.findAll();
        ArrayList<HotelDTO> show_hotels = new ArrayList<HotelDTO>();
        for(int i=0; i< hotels.size(); i++){
            show_hotels.add(this.MapModeltoDTO(hotels.get(i)));
        }
        return show_hotels;
    }
    @Override
    public HotelDTO saveHotel(HotelDTO hotel){
        HotelModel hotelModel = this.MapDTOtoModel(hotel);
        HotelDTO hotelDTO = this.MapModeltoDTO(hotelRepository.save(hotelModel));
        return hotelDTO;
    }
    @Override
    public HotelDTO getHotelById(Long hotel_id){
        HotelModel query = hotelRepository.findById(hotel_id)
                .orElseThrow(() -> new CustomBadRequestException("Hotel con ID: " + hotel_id + " No existe.", HttpStatus.BAD_REQUEST.value()));
        HotelDTO hotel = this.MapModeltoDTO(query);
        return hotel;
    }
    @Override
    public HotelDTO updateHotelById(HotelDTO request, Long hotel_id){
        HotelModel hotel = hotelRepository.findById(hotel_id).get();

        hotel.setMax_reservations(request.getMax_reservations());
        hotel.setPhone_number(request.getPhone_number());
        hotel.setEmail(request.getEmail());
        hotel.setCapacity(request.getCapacity());
        hotel.setImg_url(request.getImg_url());
        hotel.setPrice(request.getPrice());

        HotelDTO hotelDTO = this.MapModeltoDTO(hotelRepository.save(hotel));

        return hotelDTO;

    }
    @Override
    public String deleteHotel(Long hotel_id){
        try {
            hotelRepository.deleteById(hotel_id);
            System.out.println("eliminado");
            return "Deleted";
        }catch(Exception e){
            System.out.println(e);
            throw new CustomBadRequestException("Couldn't delete.", HttpStatus.BAD_REQUEST.value());
        }
    }
}