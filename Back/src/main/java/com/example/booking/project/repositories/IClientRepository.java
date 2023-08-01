package com.example.booking.project.repositories;

import com.example.booking.project.models.entities.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<ClientModel, Long> {

}
