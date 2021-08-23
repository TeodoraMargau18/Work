package com.playtika.week5.java.GamesSpringBackend.services;

import com.playtika.week5.java.GamesSpringBackend.models.BillingAddress;
import com.playtika.week5.java.GamesSpringBackend.models.Player;
import com.playtika.week5.java.GamesSpringBackend.repositories.BillingAdressRepository;
import com.playtika.week5.java.GamesSpringBackend.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    BillingAdressRepository billingAddressRepository;

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
//            BillingAddress newBillingAddress
//                    =this.billingAddressRepository.saveAndFlush(billingAddress);
            billingAddress.setPlayer(player);
            player.setBillingAddress(billingAddress);
            this.playerRepository.saveAndFlush(player);
            return player;
        }else {
            return null;
        }
    }
}
