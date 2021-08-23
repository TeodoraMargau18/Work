package com.playtika.week5.java.GamesSpringBackend.repositories;

import com.playtika.week5.java.GamesSpringBackend.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player,Long> {

    @Query(value = "SELECT * FROM PLAYERS WHERE PLAYER_GENDER='FEMALE'",nativeQuery = true)
    List<Player> getFemalePlayers();
    @Query(value = "SELECT * FROM PLAYERS WHERE PLAYER_GENDER='MALE'",nativeQuery = true)
    List<Player> getMalePlayers();

    @Query(value = "SELECT * FROM PLAYERS WHERE PLAYER_GENDER= :gender and player_age> :age",
            nativeQuery = true)
    List<Player> getPlayersByAgeAngGender(String gender,int age);

}
