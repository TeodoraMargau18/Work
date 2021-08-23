package com.playtika.GameForum;

import com.playtika.GameForum.repositories.PlayerRepository;
import com.playtika.GameForum.services.PlayerService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(Runner.class)
@SpringBootTest( webEnvironment =
		SpringBootTest.WebEnvironment.MOCK,
		classes = GameForumApplication.class
)
class GameForumApplicationTests {
	@Autowired
	PlayerService playerService;
	@Autowired
	PlayerRepository playerRepository;
	@Autowired
	private MockMvc mvc;


//	@Test
//	void contextLoads() {
//	}

	@Test
	void testPlayersEndPointURL(){
		try {
			mvc.perform(get("https://127.0.0.1:8080/api/players")).andExpect(status().isOk());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
