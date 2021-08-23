package com.playtika.GameForum.repositories;

import com.playtika.GameForum.models.PlayerSectionId;
import com.playtika.GameForum.models.SectionPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerSectionRepository extends
        JpaRepository<SectionPlayer, PlayerSectionId> {
}
