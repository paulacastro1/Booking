package com.example.booking.project.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="Client")
public class ClientModel {

    @Id
    private Long client_id;

    @Column
    private String password;

    @Column
    private String id_type;

    @Column
    private String client_name;

    private String cellphone;

}
