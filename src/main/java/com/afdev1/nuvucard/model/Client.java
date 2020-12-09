package com.afdev1.nuvucard.model;

import javax.persistence.*;

@Entity
@Table(name = "clients", schema = "public")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column
    private String first_name;

    @Column
    private String last_name;

    @Column
    private String address;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private Long telephone;

    @Column
    private Long card_number;

    @Column
    private Long card_month;

    @Column
    private Long card_year;

    @Column
    private Long card_security_code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getTelephone() {
        return telephone;
    }

    public void setTelephone(Long telephone) {
        this.telephone = telephone;
    }

    public Long getCard_number() {
        return card_number;
    }

    public void setCard_number(Long card_number) {
        this.card_number = card_number;
    }

    public Long getCard_month() {
        return card_month;
    }

    public void setCard_month(Long card_month) {
        this.card_month = card_month;
    }

    public Long getCard_year() {
        return card_year;
    }

    public void setCard_year(Long card_year) {
        this.card_year = card_year;
    }

    public Long getCard_security_code() {
        return card_security_code;
    }

    public void setCard_security_code(Long card_security_code) {
        this.card_security_code = card_security_code;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", telephone=" + telephone +
                '}';
    }
}
