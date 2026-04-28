package com.agriconnect.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.agriconnect.backend.entity.Answer;
import com.agriconnect.backend.repository.AnswerRepository;

@RestController
@RequestMapping("/api/answers")
@CrossOrigin(origins = "*") // ✅ allow frontend
public class AnswerController {

    @Autowired
    private AnswerRepository repo;

    // ✅ GET all answers
    @GetMapping
    public List<Answer> getAll() {
        return repo.findAll();
    }

    // ✅ POST new answer
    @PostMapping
    public Answer add(@RequestBody Answer ans) {
        return repo.save(ans);
    }
}