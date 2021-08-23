package com.playtika.GamesSpringBackend.controllers;

import com.playtika.GamesSpringBackend.models.BillingAddress;
import com.playtika.GamesSpringBackend.models.Player;
import com.playtika.GamesSpringBackend.services.PlayerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    PlayerService playerService;

    //pentru a trimite comenzi
    @Autowired
    JdbcTemplate jdbcTemplate;


    @GetMapping
    public List<Player> findAll(){
        return this.playerService.findAll();
    }
    @PostMapping
    public @ResponseBody Player createPlayer(@RequestBody Player player){
        return this.playerService.addPlayer(player);
    }

    @PostMapping
    @RequestMapping("/{id}/add/address")
    public Player createPlayerBillingAddress(@PathVariable long id, @RequestBody BillingAddress billingAddress){
        return this.playerService.addBillingAddress(id, billingAddress);
    }

    // va arata asa: api/players/1/add/game?gameId=2  si daca mai aveam param puneam gen => &param2=3
    @PostMapping(params = {"gameId"})
    @RequestMapping("/{id}/add/game")
    public Player addGame(@RequestParam long gameId, @PathVariable long id){
        return this.playerService.addGame(id, gameId);
    }
    // va arata asa: api/players/1/add/game?player_id=1&gameId=2
    @PostMapping(params = {"player_id","gameId"})
    @RequestMapping("/add/game")
    public Player addGameWithParams(@RequestParam long gameId, @RequestParam long player_id){
        return this.playerService.addGame(player_id, gameId);
    }

    @GetMapping
    @RequestMapping("/females")
    public List<Player> getFemales(){
        return this.playerService.getFemalePlayers();
    }

    @GetMapping
    @RequestMapping("/male")
    public List<Player> getMale(){
        return this.playerService.getMalePlayers();
    }

    //query parametrizabil
    @GetMapping(params = {"gender", "age"})
    @RequestMapping("/find")
    public List<Player> getPlayersByAgeAndGender(@RequestParam String gender, @RequestParam int age){
        return this.playerService.getPlayersByAgeAndGender(gender, age);
    }

    @GetMapping
    @RequestMapping("/page/{pageId}")
    public List<Player> getPlayerPage(@PathVariable int pageId){
        Pageable pageable = PageRequest.of(pageId, 3);
        return this.playerService.getPlayersPaginated(pageable).toList();
    }

    // sau
    // .../api/players/page?pageId=0&size=3&sort=age
    // Spring ni le mapeaza automat cand primeste parametrul de tip Pageable!!
    @GetMapping
    @RequestMapping("/page")
    public List<Player> getPaginatedPlayersByParams(Pageable pageable){
        return this.playerService.getPlayersPaginated(pageable).toList();
    }

    //queries using jdbc

    @GetMapping(params = {"name"})
    @RequestMapping("/count")
    public String getPlayersNoByAge(@RequestParam String name){
        Logger logger = LoggerFactory.getLogger(PlayerController.class);
        String query = String.format("SELECT COUNT(PLAYER_ID) FROM PLAYERS WHERE players.player_full_name like '%s'", name);
        logger.info(query);
        jdbcTemplate.execute(query);
        return "OK";
    }
}
