package com.example.booking.project.services.interfaces;

import com.example.booking.project.web.dto.ClientDTO;


import java.util.ArrayList;

public interface ClientService {
    public ArrayList<ClientDTO> getClients();
    public ClientDTO saveClient(ClientDTO client);
    public ClientDTO getClientById(Long client_id);
    public ClientDTO updateClientById(ClientDTO request, Long client_id);
    public Boolean deleteClient(Long client_id);
}
