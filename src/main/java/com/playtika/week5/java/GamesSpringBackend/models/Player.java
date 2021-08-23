package com.playtika.week5.java.GamesSpringBackend.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

@Entity()
//Dc nu dat @Table=> acelasi e si numele tabelei
//clasa java e vazuta ca o entitate logica in hibertnate
//aceasta entitate este folosita pe query-uri
//dc nu pun name , implicit e numele clasei


@Table(name="players")//numele din baza de date
public class Player {

    public enum PlayerGender {
        //ca si ordinal va pune 0,1,2
        MALE,FEMALE, NOT_DISCLOSED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id")
    private long id;

    @Column(name = "player_fullname")
    private String fullName;

    @Column(name = "player_age")
    private int age;

    @Column(name = "player_isonline")
    private boolean isOnline;

    @Column(name = "player_gender")
    @Enumerated(EnumType.STRING)
    private PlayerGender gender;

    @Column(name = "player_birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthday;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public PlayerGender getGender() {
        return gender;
    }

    public void setGender(PlayerGender gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
