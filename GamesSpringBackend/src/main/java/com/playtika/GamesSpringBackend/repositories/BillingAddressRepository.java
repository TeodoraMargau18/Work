package com.playtika.GamesSpringBackend.repositories;

import com.playtika.GamesSpringBackend.models.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingAddressRepository extends JpaRepository<BillingAddress, Long> {
}
