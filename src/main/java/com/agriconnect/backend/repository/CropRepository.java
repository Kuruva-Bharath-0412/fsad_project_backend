package com.agriconnect.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.agriconnect.backend.entity.Crop;
import com.agriconnect.backend.entity.User;
import java.util.List;

public interface CropRepository extends JpaRepository<Crop, Long> {

    List<Crop> findByFarmer(User farmer);
}