package com.playtika.week5.java.GamesSpringBackend.controllers;


import com.playtika.week5.java.GamesSpringBackend.models.BillingAddress;
import com.playtika.week5.java.GamesSpringBackend.models.Player;
import com.playtika.week5.java.GamesSpringBackend.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    public List<Player> findAll(){
        return this.playerService.getAll();
    }

    @PostMapping
    public @ResponseBody Player addNewPlayer(@RequestBody Player player){
        return this.playerService.addPlayer(player);
    }

    @PostMapping
    @RequestMapping("/{id}/add/billing")
    public @ResponseBody Player addBillingAddress(@PathVariable long id,
                                                  @RequestBody BillingAddress billingAddress){
        return this.playerService.addBillingAddress(id,billingAddress);
    }

}
