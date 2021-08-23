package com.playtika.week5.java.GamesSpringBackend.repositories;

import com.playtika.week5.java.GamesSpringBackend.models.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingAdressRepository extends JpaRepository<BillingAddress,Long> {
}
