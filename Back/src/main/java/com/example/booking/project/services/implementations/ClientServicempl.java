package com.example.booking.project.services.implementations;


import com.example.booking.project.models.entities.ClientModel;
import com.example.booking.project.web.dto.ClientDTO;
import com.example.booking.project.repositories.IClientRepository;
import com.example.booking.project.services.interfaces.ClientService;
import com.example.booking.project.web.dto.HotelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.ArrayList;

@Service
public class ClientServicempl implements ClientService {

    @Autowired
    private IClientRepository clientRepository;

    public ClientModel MapDTOtoModel(ClientDTO client){
        ClientModel clientModel = ClientModel.builder().
                client_id(client.getClient_id())
                .password(client.getPassword())
                .id_type(client.getId_type())
                .client_name(client.getClient_name())
                .cellphone(client.getCellphone())
                .build();
        return clientModel;
    }

    public ClientDTO MapModeltoDTO(ClientModel client){
        ClientDTO clientDTO = ClientDTO.builder().
                client_id(client.getClient_id())
                .password(client.getPassword())
                .id_type(client.getId_type())
                .client_name(client.getClient_name())
                .cellphone(client.getCellphone())
                .build();
        return clientDTO;
    }


    @Override
    public ArrayList<ClientDTO> getClients(){
        ArrayList<ClientModel> clients = (ArrayList<ClientModel>) this.clientRepository.findAll();
        ArrayList<ClientDTO> show_clients = new ArrayList<ClientDTO>();
        for(int i=0; i< clients.size(); i++){
            show_clients.add(this.MapModeltoDTO(clients.get(i)));
        }
        return show_clients;
    }
    @Override
    public ClientDTO saveClient(ClientDTO client){
        ClientModel clientModel = this.MapDTOtoModel(client);
        ClientDTO clientDTO = this.MapModeltoDTO(clientRepository.save(clientModel));
        return clientDTO;
    }
    @Override
    public ClientDTO getClientById(Long client_id){
        Optional<ClientModel> query = clientRepository.findById(client_id);
        ClientDTO client = this.MapModeltoDTO(query.get());
        return client;
    }
    @Override
    public ClientDTO updateClientById(ClientDTO request, Long client_id){
        ClientModel client = clientRepository.findById(client_id).get();

        client.setId_type(request.getId_type());
        client.setClient_name(request.getClient_name());
        client.setCellphone(request.getCellphone());

        ClientDTO clientDTO = this.MapModeltoDTO(clientRepository.save(client));
        return clientDTO;
    }
    @Override
    public Boolean deleteClient(Long client_id){
        try {
            clientRepository.deleteById(client_id);
            return true;
        }catch(Exception e){
            return false;
        }

    }

}
