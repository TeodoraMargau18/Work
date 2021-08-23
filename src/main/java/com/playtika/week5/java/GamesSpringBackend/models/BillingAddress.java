package com.playtika.week5.java.GamesSpringBackend.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "billing_addresses")
public class BillingAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="city")
    private String city;
    @Column(name="street")
    private String street;

//    @OneToOne
//    //name=numele atributului din coloana copil
////    referencedCollumn
////    @JoinColumn(name = "id",
////    referencedColumnName = "player_id")
//    @MapsId//id_Players are
//    private Player player;

    @JsonIgnore
    @OneToOne()
    @JoinColumn(name = "player_id")
    private Player player;

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

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
