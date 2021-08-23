package com.playtika.GameForum.models;


import java.io.Serializable;

public class PlayerSectionId implements Serializable {
    private long playerID;
    private long sectionID;

    public PlayerSectionId(long playerID, long sectionID) {
        this.playerID = playerID;
        this.sectionID = sectionID;
    }

    public PlayerSectionId() {
    }

    public long getPlayerID() {
        return playerID;
    }

    public long getSectionID() {
        return sectionID;
    }
}
