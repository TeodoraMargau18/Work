package com.playtika.GameForum.services;

import com.playtika.GameForum.models.Player;
import com.playtika.GameForum.repositories.PlayerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    public List<Player> findAllSortedByName() {
        return this.playerRepository.findAll(Sort.by(Sort.Direction.ASC, "lastname"));
    }

    public Player findById(long id) {
//        get e de la Optional , dc nu gasesc player-ul imi da o exceptie si ma ajuta sa dau mai departe la utilizator
        Optional<Player> player = this.playerRepository.findById(id);
        if (player.isPresent()) {
            return player.get();
        }
        return null;
    }

    public boolean deleteById(long id) {
        if (this.playerRepository.findById(id).isPresent()) {
            this.playerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Player createPlayer(Player player) {
        Player newPlayer = this.playerRepository.saveAndFlush(player);
        return newPlayer;
    }

    public boolean updatePlayer(Player player) {
        Optional<Player> existingPlayer = this.playerRepository.findById(player.getId());
        if (existingPlayer.isPresent()) {
//            Player existing=existingPlayer.get();
//            existing.setLastname(player.getLastname());
//            existing.setFirstname(player.getFirstname());
//            existing.setUsername(player.getUsername());
//            existing.setBio(player.getBio());
//            BeanUtils.copyProperties(existing,player);
            this.playerRepository.saveAndFlush(player);
            return true;
        }
        return false;
    }

}
