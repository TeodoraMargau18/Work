package com.playtika.GamesSpringBackend.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "players")
public class Player {

    public enum PlayerGender {
        MALE, FEMALE, NOT_DISCLOSED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private long player_id;

    @Column(name = "player_full_name")
    private String fullName;

    @Column(name = "player_age")
    private int age;

    @Column(name = "player_is_online")
    private boolean isOnline;

    @Column(name = "player_birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "player_gender")
    @Enumerated(value = EnumType.STRING)
    private PlayerGender gender;

    @JsonIgnore
    @OneToOne(mappedBy = "player", cascade = CascadeType.ALL)
    BillingAddress billingAddress;

    @ManyToMany
    @JoinTable(name = "player_games",
            joinColumns = @JoinColumn(name = "player_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"))
    List<Game> games;

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }

    public long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(long player_id) {
        this.player_id = player_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    public BillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(BillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public PlayerGender getGender() {
        return gender;
    }

    public void setGender(PlayerGender gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
