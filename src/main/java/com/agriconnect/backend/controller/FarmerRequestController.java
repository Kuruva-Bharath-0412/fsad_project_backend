package com.agriconnect.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.agriconnect.backend.entity.FarmerRequest;
import com.agriconnect.backend.repository.FarmerRequestRepository;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin(origins = "http://localhost:5174") // ✅ IMPORTANT
public class FarmerRequestController {

    @Autowired
    private FarmerRequestRepository repo;

    @PostMapping
    public FarmerRequest addRequest(@RequestBody FarmerRequest req) {
        return repo.save(req);
    }

    @GetMapping
    public List<FarmerRequest> getAll() {
        return repo.findAll();
    }
}