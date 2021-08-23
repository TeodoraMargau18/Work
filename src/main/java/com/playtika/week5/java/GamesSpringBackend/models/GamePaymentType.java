package com.playtika.week5.java.GamesSpringBackend.models;


import javax.persistence.*;
import java.lang.reflect.GenericArrayType;

@Entity
@Table(name = "payment_types")
public class GamePaymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="payment_id")
    private long id;

    @Column(name="game_id")
    private long gameId;

    @Column(name="description")
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
