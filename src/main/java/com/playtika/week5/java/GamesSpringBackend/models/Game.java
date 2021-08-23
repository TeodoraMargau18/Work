package com.playtika.week5.java.GamesSpringBackend.models;


import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {

    public enum GameType {ACTION, RPG, MMO, STRATEGY}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private long id;

    @Column(name = "game_name")
    private String name;

    @Column(name = "game_type")
    @Enumerated(EnumType.ORDINAL)
    private GameType gameType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }
}
