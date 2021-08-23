package com.playtika.modules;

import javax.persistence.*;

@Entity
@Table(name = "player_games")
public class PlayerGames {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long player_id;

    private String game;

    @Column(name = "total_points")
    private int totalPoints;

    @ManyToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "player_id",
            referencedColumnName = "id",
    insertable = false,updatable = false,nullable = false)
    private Player player;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(long player_id) {
        this.player_id = player_id;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }
}

