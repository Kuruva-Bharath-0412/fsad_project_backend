package com.agriconnect.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.agriconnect.backend.entity.Scheme;
import com.agriconnect.backend.repository.SchemeRepository;

@RestController
@RequestMapping("/api/schemes")
@CrossOrigin
public class SchemeController {

    @Autowired
    private SchemeRepository schemeRepo;

    @GetMapping
    public List<Scheme> getAllSchemes() {
        return schemeRepo.findAll();
    }
}