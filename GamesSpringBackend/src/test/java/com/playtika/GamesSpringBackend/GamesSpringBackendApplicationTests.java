package com.playtika.GamesSpringBackend;

import com.playtika.GamesSpringBackend.config.GameSettings;
import com.playtika.GamesSpringBackend.controllers.PlayerController;
import com.playtika.GamesSpringBackend.models.Player;
import com.playtika.GamesSpringBackend.services.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//alegem integration testing
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GamesSpringBackendApplicationTests {

    public static final String BASE_URL = "/api/info";

    @LocalServerPort
    private int serverPort;

    //pentru ca e test de integrare inseamna ca avem nevoie de servicii si le injectam aici
    @Autowired
    PlayerService playerService;

    //ca sa primim codul de eroare/succes
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void contextLoads() {
    }

    @Test
    void testPlayerControllerIsUp() {
        String fullURL = "http://127.0.0.1:" + serverPort + BASE_URL;
        ResponseEntity<GameSettings> responseEntity = testRestTemplate.getForEntity(fullURL, GameSettings.class);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void testPlayerControllerData() {
        String fullURL = "http://127.0.0.1:" + serverPort + BASE_URL;
        ResponseEntity<GameSettings> responseEntity = testRestTemplate.getForEntity(fullURL, GameSettings.class);
        assertThat(responseEntity.getBody().getVersion()).isEqualTo("1.0.0");
    }
}
