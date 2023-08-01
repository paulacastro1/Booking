package com.example.booking.project.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO {
    private Long client_id;
    private String password;
    private String id_type;
    private String client_name;
    private String cellphone;

}
