package com.playtika.SpringBootApp.services;

import com.playtika.SpringBootApp.models.Player;
import com.playtika.SpringBootApp.repositories.PlayersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayersService {

    @Autowired
    private PlayersRepository playersRepository;

    public List<Player> findAll(){
        return playersRepository.findAll();
    }

    public Player getPlayerById(long id){
        return playersRepository.findById(id).get();
    }
}
