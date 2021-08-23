package com.playtika.GamesSpringBackend.controllers;

import com.playtika.GamesSpringBackend.config.GameSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/info")
public class InfoController {

    @Autowired
    GameSettings gameSettings;

    @GetMapping
    public GameSettings getGameSettings(){
        return this.gameSettings;
    }


}
