package com.playtika.GameForum.models;

import javax.persistence.*;

@Entity
@Table(name = "section_players")
@IdClass(PlayerSectionId.class)
public class SectionPlayer {
    @Id
    @Column(name = "player_id")
    private long playerID;
    @Id
    @Column(name = "section_id")
    private long sectionID;

    public long getPlayerID() {
        return playerID;
    }

    public void setPlayerID(long playerID) {
        this.playerID = playerID;
    }

    public long getSectionID() {
        return sectionID;
    }

    public void setSectionID(long sectionID) {
        this.sectionID = sectionID;
    }
}
