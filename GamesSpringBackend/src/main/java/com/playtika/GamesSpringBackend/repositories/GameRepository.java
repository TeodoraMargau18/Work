package com.playtika.GamesSpringBackend.repositories;

import com.playtika.GamesSpringBackend.models.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
