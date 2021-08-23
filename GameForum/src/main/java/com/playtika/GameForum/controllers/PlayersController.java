package com.playtika.GameForum.controllers;

import com.playtika.GameForum.exceptions.MyResponseBody;
import com.playtika.GameForum.exceptions.PlayerNotFoundException;
import com.playtika.GameForum.models.Player;
import com.playtika.GameForum.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayersController {

    @Autowired
    PlayerService playerService;

    @GetMapping
    public List<Player> getAll(){
        return this.playerService.findAll();
    }

    @GetMapping
    @RequestMapping("/sorted")
    public List<Player> getAllSorted(){
        return this.playerService.findAllSortedByName();
    }


    @GetMapping
    @RequestMapping("/{id}")
    public Player getPlayerById(@PathVariable long id){
        Player player= this.playerService.findById(id);
        if(player==null){
            throw new PlayerNotFoundException();
        }
        return player;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public  ResponseEntity<Player> createNewPlayer(@RequestBody Player player){
        if(this.playerService.findById(player.getId())!=null){
            return new ResponseEntity<Player>(player,HttpStatus.BAD_REQUEST);
        }else{
            Player createdPlayer=playerService.createPlayer(player);
            return new ResponseEntity<>(createdPlayer,HttpStatus.CREATED);
        }
    }

//    UPDATE
@PutMapping
public  ResponseEntity<Boolean> updatePlayer(@RequestBody Player player){
    if(this.playerService.findById(player.getId())==null){
        return new ResponseEntity<Boolean>(false,HttpStatus.NOT_FOUND);
    }else{
        this.playerService.updatePlayer(player);
        return new ResponseEntity<>(true,HttpStatus.OK);
    }
}

    @DeleteMapping
    public boolean deletePlayerById(@RequestBody long id){
        return this.playerService.deleteById(id);
    }


    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public  ResponseEntity<MyResponseBody> handleExceptions(Exception ex){
        if(ex instanceof PlayerNotFoundException){
//            return new ControllerGenericExceptionMessage
//            ("Player not found!",HttpStatus.NOT_FOUND);

            return new ResponseEntity<MyResponseBody>
                    (new MyResponseBody("Player not found! "
                            ,HttpStatus.NOT_FOUND.value()),HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<MyResponseBody>(new MyResponseBody("Huston, we have a problem!",
                HttpStatus.INTERNAL_SERVER_ERROR.value()),HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
