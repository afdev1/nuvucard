package com.afdev1.nuvucard.repository;

import com.afdev1.nuvucard.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    Administrator findByUsername(String username);
}
