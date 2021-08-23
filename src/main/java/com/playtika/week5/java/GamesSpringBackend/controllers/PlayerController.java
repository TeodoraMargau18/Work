package com.playtika.week5.java.GamesSpringBackend.controllers;


import com.playtika.week5.java.GamesSpringBackend.models.BillingAddress;
import com.playtika.week5.java.GamesSpringBackend.models.Player;
import com.playtika.week5.java.GamesSpringBackend.services.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;
    @Autowired
    JdbcTemplate jdbcTemplate;//ne conecteaza la mariadv

    @GetMapping
    public @ResponseBody List<Player> findAll(){
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

    @PostMapping(params = {"gameId"})
    @RequestMapping("/{id}/add")
    public @ResponseBody Player addGame(@PathVariable long id,@RequestParam long gameId){
        return this.playerService.addGame(id,gameId);
    }

    @PostMapping(params = {"playerId","gameId"})
    @RequestMapping("/addGame")
    public @ResponseBody Player addGameParams(@RequestParam long playerId,@RequestParam long gameId){
        return this.playerService.addGame(playerId,gameId);
    }

    @GetMapping
    @RequestMapping("/female")
    public List<Player> getFemalePlayers(){
        return this.playerService.getFemalePlayer();
    }
    @GetMapping
    @RequestMapping("/male")
    public List<Player> getMalePlayers(){
        return this.playerService.getMalePlayer();
    }

    @GetMapping(params = {"gender","minAge"})
    @RequestMapping("/find")
    public List<Player> getPlayersByAgeAngGender(@RequestParam String gender, @RequestParam int minAge){
        return this.playerService.getPlayerByAgeAndGender(gender,minAge);
    }

    @GetMapping
    @RequestMapping("/page/{pageId}")
    public List<Player> getPlayerPage(@PathVariable int pageId){
        Pageable pageable= PageRequest.of(pageId,3);
        return this.playerService.getPlayerPage(pageable).toList();
    }

    @GetMapping
    @RequestMapping("/page")
    public List<Player> getPlayerPage(Pageable pageable){
        return this.playerService.getPlayerPage(pageable).toList();
    }

//    Filter with JDBC
    //return count
    @GetMapping(params = {"nameFilter"})
    @RequestMapping("/count")
    public String getPlayerNumberByAge(@RequestParam String nameFilter ){

        Logger logger= LoggerFactory.getLogger(PlayerController.class);

        String query=String.format("Select count(player_id) from players where player_fullname LIKE '%s' ",nameFilter);
        logger.info(query);
        jdbcTemplate.execute(query);
        return "OK";
    }


}
