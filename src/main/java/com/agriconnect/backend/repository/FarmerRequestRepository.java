package com.agriconnect.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agriconnect.backend.entity.FarmerRequest;

public interface FarmerRequestRepository extends JpaRepository<FarmerRequest, Long> {
}