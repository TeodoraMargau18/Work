package com.playtika.GameForum.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "forum_sections")
public class ForumSection {
    @Id
    @Column(name="section_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "section_name")
    private String sectionName;

    @Column(name = "section_description")
    private String sectionDescription;

    @Column(name = "section_players_limit")
    private int sectionPlayerLimit;

    @ManyToMany
    @JoinTable(
            name = "section_players",
            joinColumns = @JoinColumn(name = "section_id",
            referencedColumnName = "section_id"),
            inverseJoinColumns = @JoinColumn(name = "player_id",
            referencedColumnName = "id")
    )
    private List<Player> players;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionDescription() {
        return sectionDescription;
    }

    public void setSectionDescription(String sectionDescription) {
        this.sectionDescription = sectionDescription;
    }

    public int getSectionPlayerLimit() {
        return sectionPlayerLimit;
    }

    public void setSectionPlayerLimit(int sectionPlayerLimit) {
        this.sectionPlayerLimit = sectionPlayerLimit;
    }

    public List<Player> getPlayers() {
        return players;
    }
}
