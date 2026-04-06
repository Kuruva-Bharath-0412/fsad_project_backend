package com.agriconnect.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agriconnect.backend.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {
}