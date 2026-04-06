package com.agriconnect.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.agriconnect.backend.entity.FarmerReply;
import com.agriconnect.backend.repository.FarmerReplyRepository;

@RestController
@RequestMapping("/api/replies")
@CrossOrigin(origins = "http://localhost:5174")
public class FarmerReplyController {

    @Autowired
    private FarmerReplyRepository repo;

    // save reply
    @PostMapping
    public FarmerReply addReply(@RequestBody FarmerReply reply) {
        return repo.save(reply);
    }

    // get replies for a request
    @GetMapping("/{requestId}")
    public List<FarmerReply> getReplies(@PathVariable Long requestId) {
        return repo.findByRequestId(requestId);
    }
}