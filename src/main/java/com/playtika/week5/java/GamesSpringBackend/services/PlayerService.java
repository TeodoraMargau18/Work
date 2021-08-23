package com.playtika.week5.java.GamesSpringBackend.services;

import com.playtika.week5.java.GamesSpringBackend.models.BillingAddress;
import com.playtika.week5.java.GamesSpringBackend.models.Game;
import com.playtika.week5.java.GamesSpringBackend.models.Player;
import com.playtika.week5.java.GamesSpringBackend.repositories.BillingAdressRepository;
import com.playtika.week5.java.GamesSpringBackend.repositories.GameRepository;
import com.playtika.week5.java.GamesSpringBackend.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    GameRepository gameRepository;

    public List<Player> getAll(){
        return playerRepository.findAll();
    }

    public Player addPlayer(Player player){
        return this.playerRepository.saveAndFlush(player);
    }

    public Player addBillingAddress(long id,BillingAddress billingAddress){
        Optional<Player> playerOptional=this.playerRepository.findById(id);
        if(playerOptional.isPresent()){
            Player player=playerOptional.get();
            billingAddress.setPlayer(player);
            player.setBillingAddress(billingAddress);
            this.playerRepository.saveAndFlush(player);
            return player;
        }else {
            return null;
        }
    }
    public Player addGame(long player_id, long game_id){
        Optional<Player> playerOptional=playerRepository.findById(player_id);
        Optional<Game> gameOptional=gameRepository.findById(game_id);
        if(playerOptional.isPresent()&&gameOptional.isPresent()){
            Player player=playerOptional.get();
            player.getGames().add(gameOptional.get());
            this.playerRepository.saveAndFlush(player);
            return player;
        }else{
            return null;
        }
    }
    public List<Player> getFemalePlayer(){
        return this.playerRepository.getFemalePlayers();
    }

    public List<Player> getMalePlayer(){
        return this.playerRepository.getMalePlayers();
    }

    public List<Player> getPlayerByAgeAndGender(String gender,int age){
        return  this.playerRepository.getPlayersByAgeAngGender(gender,age);
    }

    public Page<Player> getPlayerPage(Pageable pageable){
        return this.playerRepository.findAll(pageable);
    }
}
