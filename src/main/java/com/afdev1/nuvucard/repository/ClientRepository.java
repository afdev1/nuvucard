package com.afdev1.nuvucard.repository;

import com.afdev1.nuvucard.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query(value = "UPDATE clients SET username= :un, password= :pw, email= :email, first_name= :fn, " +
            "last_name= :ln, address= :add, city= :city, country= :country, telephone= :tel, card_number= :num, card_month=:month, " +
            "card_year= :year, card_security_code= :sec where id= :id", nativeQuery = true)
    @Modifying(clearAutomatically = true)
    @Transactional
    void updateClient(@Param("id") long id, @Param("un") String username, @Param("pw") String password,
                          @Param("email") String email, @Param("fn") String first_name, @Param("ln") String last_name,
                          @Param("add") String address, @Param("city") String city, @Param("country") String country,
                          @Param("tel") Long telephone, @Param("num") Long card_number, @Param("month") Long card_month,
                          @Param("year") Long card_year, @Param("sec") Long card_security_code);
}
