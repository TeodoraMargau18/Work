package com.playtika.modules;

import javax.persistence.*;
import java.util.List;

//pentru tabela din memorie hibernate
@Entity(name = "PlayerEntity")
//tabela fizica din baza de date
@Table(name = "Player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fullName")
    private String fullName;

    private String bio;
    private int age;

    @OneToMany(mappedBy = "player")
//    @OneToMany
    private List<PlayerGames> games;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}





