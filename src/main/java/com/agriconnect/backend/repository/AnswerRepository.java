package com.agriconnect.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agriconnect.backend.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}