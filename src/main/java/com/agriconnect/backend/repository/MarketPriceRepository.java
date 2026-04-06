package com.agriconnect.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agriconnect.backend.entity.MarketPrice;

public interface MarketPriceRepository extends JpaRepository<MarketPrice, Long> {
}