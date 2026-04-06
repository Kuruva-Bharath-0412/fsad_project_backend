package com.agriconnect.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agriconnect.backend.entity.Question;
import com.agriconnect.backend.entity.User;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByExpert(User expert);

    List<Question> findByFarmer(User farmer);
}