package com.agriconnect.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.agriconnect.backend.entity.MarketPrice;
import com.agriconnect.backend.repository.MarketPriceRepository;

@RestController
@RequestMapping("/api/market")
@CrossOrigin(origins = "*") // ✅ allow all (for now)
public class MarketController {

    @Autowired
    private MarketPriceRepository repo;

    // ✅ GET all prices (for farmers)
    @GetMapping
    public List<MarketPrice> getPrices() {
        return repo.findAll();
    }

    // ✅ POST (only admin will use from frontend)
    @PostMapping
    public MarketPrice addPrice(@RequestBody MarketPrice price) {
        return repo.save(price);
    }
}