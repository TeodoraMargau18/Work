package com.playtika.week5.java.GamesSpringBackend.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "billing_addresses")
public class BillingAddress {

    @Id
    @Column(name="player_id")
    private long id;
    @Column(name="city")
    private String city;
    @Column(name="street")
    private String street;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
