package com.playtika.GamesSpringBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {

    public Game() {
    }

    public enum GameType{
        ACTION, RPG, MMO, STRATEGY
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private long gameId;

    @Column(name = "game_name")
    private String gameName;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "game_type")
    private GameType gameType;

    @JsonIgnore
    @ManyToMany(mappedBy = "games")
    private List<Player> players;

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
