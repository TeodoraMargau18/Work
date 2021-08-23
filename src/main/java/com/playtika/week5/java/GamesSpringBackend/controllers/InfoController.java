package com.playtika.week5.java.GamesSpringBackend.controllers;

import com.playtika.week5.java.GamesSpringBackend.config.GameSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RestController("/api/info")-in a single line
@RequestMapping("/api/info")
public class InfoController {

    @Autowired
    GameSettings gameSettings;

    @GetMapping
    public GameSettings getSettings(){
        return this.gameSettings;
    }
}
