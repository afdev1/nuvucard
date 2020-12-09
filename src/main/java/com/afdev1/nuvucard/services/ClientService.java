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
        client.setPassword(bcryptEncoder.encode(client.getPassword()));
        clientRepository.save(client);
    }

    public Optional<Client> update(Long id) {
        return clientRepository.findById(id);
    }

    public void update(Client client) {
        System.out.println(client);
        clientRepository.updateClient(
                client.getId(),
                client.getUsername(),
                client.getPassword(),
                client.getEmail(), client.getFirst_name(), client.getLast_name(), client.getAddress(),
                client.getCity(), client.getCountry(), client.getTelephone(), client.getCard_number(),
                client.getCard_month(), client.getCard_year(), client.getCard_security_code());
    }

    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}
