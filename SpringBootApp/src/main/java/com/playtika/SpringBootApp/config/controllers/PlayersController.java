package com.playtika.SpringBootApp.config.controllers;

import com.playtika.SpringBootApp.exceptions.BadRequestException;
import com.playtika.SpringBootApp.models.Player;
import com.playtika.SpringBootApp.services.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayersController {
    @Autowired
    PlayersService playersService;

    @GetMapping
    List<Player> getAll() {
        return this.playersService.findAll();
    }

    @GetMapping
    @RequestMapping("/{id}")//param de aici trb sa fie acceasi cu cea a functiei ca si denumire !
    public Player getPlayerById(@PathVariable long id) throws BadRequestException {
        try {
            Player player = this.playersService.getPlayerById(id);
            return player;
        } catch (Exception exception) {
            throw new BadRequestException();
        }
    }

    //    Are rol de catch
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    imi returneaza valoarea ca body
    public @ResponseBody
    String exceptionsHandler(BadRequestException exception) {
        return "Bad request. Invalid ID!";
    }

}
