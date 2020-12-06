package com.afdev1.nuvucard.services;

import com.afdev1.nuvucard.model.Administrator;
import com.afdev1.nuvucard.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdministratorService implements UserDetailsService {
    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Administrator administrator = administratorRepository.findByUsername(username);
        return new User(administrator.getUsername(), administrator.getPassword(), new ArrayList<>());
    }
}
