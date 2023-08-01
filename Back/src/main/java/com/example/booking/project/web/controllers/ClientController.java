package com.example.booking.project.web.controllers;

import com.example.booking.project.web.dto.ClientDTO;
import com.example.booking.project.services.implementations.ClientServicempl;
import com.example.booking.project.web.dto.HotelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientServicempl clientService;

    @GetMapping
    public ArrayList<ClientDTO> getClients(){
        return this.clientService.getClients();
    }

    @PostMapping
    public ClientDTO saveClient(@RequestBody ClientDTO client){
        return this.clientService.saveClient(client);
    }

    @GetMapping(path= "/{client_id}")
    public ClientDTO getClientById(@PathVariable Long client_id){
        return this.clientService.getClientById(client_id);
    }

    @PutMapping
    public ClientDTO updateClientById(@RequestBody ClientDTO request, @PathVariable("client_id") Long client_id){
        return this.clientService.updateClientById(request, client_id);
    }

    @DeleteMapping(path = "/{client_id}")
    public String deleteClientById(@PathVariable("client_id") Long client_id){
        boolean ok = this.clientService.deleteClient(client_id);
        if(ok){
            return ("User " + client_id + " deleted.");
        }
        else{
            return ("Couldn't complete deletion.");
        }
    }
}
