package com.playtika.GameForum.repositories;

import com.playtika.GameForum.models.ForumSection;
import com.playtika.GameForum.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumSectionRepository extends JpaRepository<ForumSection,Long> {
}
