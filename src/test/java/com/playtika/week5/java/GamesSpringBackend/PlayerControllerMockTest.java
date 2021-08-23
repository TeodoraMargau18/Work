package com.playtika.week5.java.GamesSpringBackend;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.playtika.week5.java.GamesSpringBackend.models.Player;
import com.playtika.week5.java.GamesSpringBackend.services.PlayerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;

//@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerMockTest {
    //    se creaza o instanta a controller-ului
    @Autowired
    MockMvc mockMvc;

    @MockBean
    PlayerService playerService;

    @Test
    public void test() throws Exception {
        mockMvc.perform(get("/api/info")).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.version").value("1.0.0"));
    }
    @Test
    public void testPlayersControllers() throws Exception {
        ArrayList<Player> players=new ArrayList<>();
        players.add(new Player());
        when(playerService.getAll()).thenReturn(players);

        mockMvc.perform(get("/api/players")).andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].fullName").value(""));
    }
}
