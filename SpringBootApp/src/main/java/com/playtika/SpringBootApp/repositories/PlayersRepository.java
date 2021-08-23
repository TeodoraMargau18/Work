package com.playtika.SpringBootApp.repositories;

import com.playtika.SpringBootApp.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayersRepository extends JpaRepository<Player,Long> {
//    we get all CRUD operation
}
