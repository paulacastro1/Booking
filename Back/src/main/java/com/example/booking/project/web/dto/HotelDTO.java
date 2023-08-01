package com.example.booking.project.web.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotelDTO {
    private Long hotel_id;
    private String hotel_name;
    private int max_reservations;
    private String phone_number;
    private String email;
    private int capacity;
    private String img_url;
    private Long price;
}
