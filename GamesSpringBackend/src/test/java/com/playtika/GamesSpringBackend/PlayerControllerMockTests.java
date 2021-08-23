package com.playtika.GamesSpringBackend;

import com.playtika.GamesSpringBackend.controllers.PlayerController;
import com.playtika.GamesSpringBackend.models.Player;
import com.playtika.GamesSpringBackend.services.PlayerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class PlayerControllerMockTests {

    @Autowired
    MockMvc mockMvc;

    //cand da, drumul la test, se va porni doar controllerul( baza de date nu exista, nici servicii sau repo) de aia trebuie sa ii oferim un mock pentru servicii
    @MockBean
    PlayerService playerService;

    @Test
    public void testPlayerControllerAddPlayer() throws Exception {
        ArrayList<Player> players = new ArrayList<Player>();
        players.add(new Player());
        when(playerService.findAll()).thenReturn(players);

        mockMvc.perform(get("/api/players"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].fullName").value(""));
    }
}
