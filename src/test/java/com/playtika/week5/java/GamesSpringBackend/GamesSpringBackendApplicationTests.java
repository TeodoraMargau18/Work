package com.playtika.week5.java.GamesSpringBackend;

import com.playtika.week5.java.GamesSpringBackend.config.GameSettings;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment =
        SpringBootTest.WebEnvironment.RANDOM_PORT)
class GamesSpringBackendApplicationTests {

    @LocalServerPort
    private int serverPort;
    private static final String BASE_URL="/api/info";

    //daca am nevoie de servicii , le injectez-> ruleaza ca aplicatia reala
//	doar ca pe alt port

    @Autowired
    TestRestTemplate testRestTemplate;


    @Test
    void contextLoads() {
    }
//ruleaza tot sistemul
    @Test
    void testInfoControllerIsUp() {
        String fullURL="http://localhost:"+serverPort+BASE_URL;
        ResponseEntity<GameSettings> responseEntity = testRestTemplate.getForEntity(fullURL, GameSettings.class);
        Assertions.assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

    @Test
    void testInfoControllerVersion() {
        String fullURL="http://localhost:"+serverPort+BASE_URL;
        ResponseEntity<GameSettings> responseEntity = testRestTemplate.getForEntity(fullURL, GameSettings.class);
        Assertions.assertThat(responseEntity.getBody().getVersion()).isEqualTo("5.0.0");
    }

}
