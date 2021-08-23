package com.playtika.GamesSpringBackend.services;

import com.playtika.GamesSpringBackend.models.BillingAddress;
import com.playtika.GamesSpringBackend.models.Game;
import com.playtika.GamesSpringBackend.models.Player;
import com.playtika.GamesSpringBackend.repositories.BillingAddressRepository;
import com.playtika.GamesSpringBackend.repositories.GameRepository;
import com.playtika.GamesSpringBackend.repositories.PlayerRepository;
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
    BillingAddressRepository billingAddressRepository;

    @Autowired
    GameRepository gameRepository;

    public List<Player> findAll(){
        return this.playerRepository.findAll();
    }

    public Player addBillingAddress(long id, BillingAddress billingAddress){
        Optional<Player> player = this.playerRepository.findById(id);
        if(player.isPresent()){
            Player playerFound = player.get();
//            BillingAddress newBillingAdd = this.billingAddressRepository.saveAndFlush(billingAddress);
            billingAddress.setPlayer(playerFound);
            playerFound.setBillingAddress(billingAddress);
            this.playerRepository.saveAndFlush(playerFound);
            return playerFound;
        }else {
            return null;
        }
    }

    public Player addPlayer(Player player){
        return this.playerRepository.saveAndFlush(player);
    }

    //game trebuie deja sa existe
    public Player addGame(long playerId, long gameId){
        Optional<Player> player = playerRepository.findById(playerId);
        Optional<Game> game = gameRepository.findById(gameId);

        if(player.isPresent() && game.isPresent()){
            Player player1 = player.get();
            player1.getGames().add(game.get());
            this.playerRepository.saveAndFlush(player1);
        }
        return null;
    }

    public List<Player> getFemalePlayers(){
        return playerRepository.getFemalePlayers();
    }

    public List<Player> getMalePlayers(){
        return playerRepository.getMalePlayers();
    }

    public List<Player> getPlayersByAgeAndGender(String gender, int age){
        return this.playerRepository.getPlayersByAgeAndGender(gender, age);
    }

    public Page<Player> getPlayersPaginated(Pageable pageable){
        return this.playerRepository.findAll(pageable);
    }
}
