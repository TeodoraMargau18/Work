package com.playtika.week5.java.GamesSpringBackend.repositories;

import com.playtika.week5.java.GamesSpringBackend.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player,Long> {
}
