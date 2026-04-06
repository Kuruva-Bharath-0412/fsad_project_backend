package com.agriconnect.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.agriconnect.backend.entity.MarketPrice;
import com.agriconnect.backend.repository.MarketPriceRepository;

import com.agriconnect.backend.service.MarketService;
@RestController
@RequestMapping("/api/market")
@CrossOrigin
public class MarketController {

    @Autowired
    private MarketPriceRepository repo;

    @GetMapping
    public List<MarketPrice> getPrices() {
        return repo.findAll();
    }

}