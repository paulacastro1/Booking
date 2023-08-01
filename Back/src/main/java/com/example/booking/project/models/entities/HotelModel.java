package com.example.booking.project.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JoinColumnOrFormula;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Hotel")
public class HotelModel {

    @Id
    private Long hotel_id;

    @Column
    private String hotel_name;
    @Column
    private int max_reservations;
    @Column
    private String phone_number;
    @Column
    private String email;
    @Column
    private int capacity;
    @Column
    private String img_url;
    @Column
    private Long price;

}
