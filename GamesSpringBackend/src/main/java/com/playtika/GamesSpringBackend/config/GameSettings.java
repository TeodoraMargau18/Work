package com.playtika.GamesSpringBackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component()
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@PropertySource("classpath:games.properties")
public class GameSettings {

    @Value("${app.version:0.0.0}")
    private String version;

    @Value("${description}")
    private String description;

    @Value("${no.of.max.players}")
    private int maxPlayers;

    @Value("${developers}")
    private String[] developers;

    @Value("${ports}")
    private Integer[] ports;

    @Value("#{${contributions}}")
    private Map<String, Integer> contributionMap;

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
        return developers.clone();
    }

    public Integer[] getPorts() {
        return ports.clone();
    }

    public Map<String, Integer> getContributionMap() {
        return new HashMap<>(this.contributionMap);
    }
}
