package com.playtika.week5.java.GamesSpringBackend.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

//-----------------petru a injecta din properties-------------
@PropertySource("classpath:games.properties")
public class GameSettings {

    @Value("${app.version:0.0.0.0")
    private  String version;
    @Value("${description}")
    private String description;
    @Value("${no.max.players")
    private int maxPlayers;
    @Value("${developers}")
    private String[] developers;
    @Value("${ports}")
    private Integer[] ports;
    @Value("#{${contribution}}")
    private Map<String,Integer> contribution;


    public String getVersion() {
        return version;
    }

    public String getDescription() {
        return description;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public String[] getDevelopers() {
        return developers;
    }

    public Integer[] getPorts() {
        return ports.clone();
    }

    public Map<String, Integer> getContribution() {
        return new HashMap<>(this.contribution);
    }
}
