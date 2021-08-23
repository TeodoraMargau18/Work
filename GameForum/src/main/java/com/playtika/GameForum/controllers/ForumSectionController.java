package com.playtika.GameForum.controllers;

import com.playtika.GameForum.exceptions.MyResponseBody;
import com.playtika.GameForum.exceptions.ForumSectionNotFoundException;
import com.playtika.GameForum.models.ForumSection;
import com.playtika.GameForum.models.SectionPlayer;
import com.playtika.GameForum.services.ForumSectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sections")
public class ForumSectionController {

    @Autowired
    ForumSectionService forumSectionService;

    @GetMapping
    public List<ForumSection> getAll() {
        return this.forumSectionService.findAll();
    }


    @GetMapping
    @RequestMapping("/{id}")
    public ForumSection getForumSectionById(@PathVariable long id) {
        ForumSection forumSection = this.forumSectionService.findById(id);
        if (forumSection == null) {
            throw new ForumSectionNotFoundException();
        }
        return forumSection;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ForumSection> createNewForumSection
            (@RequestBody ForumSection forumSection) {
        if (this.forumSectionService.findById(forumSection.getId()) != null) {
            return new ResponseEntity<ForumSection>(forumSection,
                    HttpStatus.BAD_REQUEST);
        } else {
            ForumSection createdForum = forumSectionService.createForumSection
                    (forumSection);
            return new ResponseEntity<>(createdForum, HttpStatus.CREATED);
        }
    }

    @DeleteMapping
    public boolean deleteForumById(@RequestBody long id) {
        return this.forumSectionService.deleteById(id);
    }

    @PutMapping
    public ResponseEntity<Boolean> updateForumSection
            (@RequestBody ForumSection forumSection) {
        if (!this.forumSectionService.updateForumSection(forumSection)) {
            return new ResponseEntity<Boolean>(false,
                    HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(this.forumSectionService.updateForumSection(forumSection), HttpStatus.CREATED);
        }
    }

    @PostMapping
    @RequestMapping("/{id_section}/register/{id_player}")
    public boolean registerPlayer(@PathVariable long id_section, @PathVariable long id_player) {
        SectionPlayer sectionPlayer = new SectionPlayer();
        sectionPlayer.setPlayerID(id_player);
        sectionPlayer.setSectionID(id_section);
        return forumSectionService.registerPlayerIntoSection(sectionPlayer);
    }

    @PostMapping
    @RequestMapping("/register")
    public boolean registerPlayer(@RequestBody SectionPlayer sectionPlayer) {
        return forumSectionService.registerPlayerIntoSection(sectionPlayer);
    }

    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<MyResponseBody> handleExceptions(Exception ex) {
        if (ex instanceof ForumSectionNotFoundException) {
            return new ResponseEntity<MyResponseBody>
                    (new MyResponseBody("Forum not found! "
                            , HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<MyResponseBody>(new MyResponseBody("Huston, we have a problem!",
                HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
