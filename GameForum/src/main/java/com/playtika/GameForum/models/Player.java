package com.playtika.GameForum.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "username")
    private String username;

    @Column(name = "player_bio")
    private String bio;

//    aici am numele colectiei care face maparea
//    Prima adnotare e pusa pentru a nu rula la infinit

    @JsonIgnore
    @ManyToMany(mappedBy = "players")
    private List<ForumSection> sections;

    @Transient
//    json ignore face ca acest camp sa nu se mai vada in rasounsul de la
//    cererea din baza de date
    @JsonIgnore
    private String fullName;

    @PostLoad
    public void initFullName(){
        this.fullName=this.lastname+" "+this.firstname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        initFullName();
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        initFullName();
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFullName() {
        return fullName;
    }

    public List<ForumSection> getSections() {
        return sections;
    }
}
