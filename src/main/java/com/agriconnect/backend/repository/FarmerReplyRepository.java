package com.agriconnect.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agriconnect.backend.entity.FarmerReply;

import java.util.List;

public interface FarmerReplyRepository extends JpaRepository<FarmerReply, Long> {
    List<FarmerReply> findByRequestId(Long requestId);
}