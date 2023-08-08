package com.example.booking.project.models.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class OccupancyModel {
    @Id
    private Long hotel_id;
    @Column
    private Long rooms;
    @Column
    private Long guests;

}
