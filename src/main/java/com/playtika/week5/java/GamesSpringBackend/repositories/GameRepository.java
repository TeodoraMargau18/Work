package com.playtika.week5.java.GamesSpringBackend.repositories;

import com.playtika.week5.java.GamesSpringBackend.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
}
