package com.playtika.GamesSpringBackend.repositories;

import com.playtika.GamesSpringBackend.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query(value = "SELECT * FROM PLAYERS WHERE player_gender = 'FEMALE'", nativeQuery = true)
    List<Player> getFemalePlayers();

    @Query(value = "SELECT * FROM PLAYERS WHERE player_gender = 'MALE'", nativeQuery = true)
    List<Player> getMalePlayers();

    //cu parametri:
    @Query(value = "SELECT * FROM PLAYERS p WHERE p.player_gender = :gender AND p.player_age > :age", nativeQuery = true)
    List<Player> getPlayersByAgeAndGender( String gender, int age);
}
