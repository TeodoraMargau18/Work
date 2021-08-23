package com.playtika.GameForum.services;

import com.playtika.GameForum.models.ForumSection;
import com.playtika.GameForum.models.SectionPlayer;
import com.playtika.GameForum.repositories.ForumSectionRepository;
import com.playtika.GameForum.repositories.PlayerSectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ForumSectionService {

    @Autowired
    ForumSectionRepository forumSectionRepository;
    @Autowired
    PlayerSectionRepository playerSectionRepository;

    public boolean registerPlayerIntoSection(SectionPlayer sectionPlayer){
        this.playerSectionRepository.saveAndFlush(sectionPlayer);
        return true;
    }


    public List<ForumSection> findAll() {
        return forumSectionRepository.findAll();
    }

    public ForumSection findById(long id) {
        Optional<ForumSection> forumSection = this.forumSectionRepository.findById(id);
        if (forumSection.isPresent()) {
            return forumSection.get();
        }
        return null;
    }

    public boolean deleteById(long id) {
        if (this.forumSectionRepository.findById(id).isPresent()) {
            this.forumSectionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ForumSection createForumSection(ForumSection forumSection) {
        ForumSection newForumSection = this.forumSectionRepository.
                saveAndFlush(forumSection);
        return newForumSection;
    }

    public boolean updateForumSection(ForumSection forumSection) {
        Optional<ForumSection> existingForumSection = this.forumSectionRepository
                .findById(forumSection.getId());
        if (existingForumSection.isPresent()) {
            this.forumSectionRepository.saveAndFlush(forumSection);
            return true;
        }
        return false;
    }

}
