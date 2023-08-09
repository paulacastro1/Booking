package com.example.booking.project.web.controllers;

import com.example.booking.project.web.dto.ClientDTO;
import com.example.booking.project.services.implementations.ClientServicempl;
import com.example.booking.project.web.dto.HotelDTO;
import com.example.booking.project.web.excepction.CustomBadRequestException;
import com.example.booking.project.web.excepction.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import com.example.booking.project.web.excepction.CustomBadRequestException;
import com.example.booking.project.web.excepction.ErrorResponse;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientServicempl clientService;

    @GetMapping
    public ResponseEntity<ArrayList<ClientDTO>> getClients(){
        return new ResponseEntity<>(this.clientService.getClients(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientDTO> saveClient(@RequestBody ClientDTO client){
        return new ResponseEntity<>( this.clientService.saveClient(client), HttpStatus.OK);
    }

    @GetMapping(path= "/{client_id}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long client_id){
        return new ResponseEntity<>( this.clientService.getClientById(client_id), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<ClientDTO> updateClientById(@RequestBody ClientDTO request, @PathVariable("client_id") Long client_id){
        return new ResponseEntity<>( this.clientService.updateClientById(request, client_id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{client_id}")
    public ResponseEntity<String> deleteClientById(@PathVariable("client_id") Long client_id){
        return new ResponseEntity<>(this.clientService.deleteClient(client_id), HttpStatus.OK);
    }

    @ExceptionHandler(CustomBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleCustomBadRequestException(CustomBadRequestException ex) {
        return new ErrorResponse(LocalDateTime.now(), ex.getStatus(), ex.getMessage());
    }
}
