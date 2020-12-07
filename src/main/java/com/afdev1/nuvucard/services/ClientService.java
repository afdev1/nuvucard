package com.afdev1.nuvucard.services;

import com.afdev1.nuvucard.model.Client;
import com.afdev1.nuvucard.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClientService{
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    public ArrayList<Client> loadAll(){
        return (ArrayList<Client>) clientRepository.findAll();
    }

    public void save(Client client) {
        clientRepository.save(client);
    }

    public Optional<Client> update(Long id) {
        return clientRepository.findById(id);
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
