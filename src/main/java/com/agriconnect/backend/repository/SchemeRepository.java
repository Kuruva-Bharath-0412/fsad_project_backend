package com.agriconnect.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agriconnect.backend.entity.Scheme;

public interface SchemeRepository extends JpaRepository<Scheme, Long> {
}