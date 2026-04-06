package com.agriconnect.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.agriconnect.backend.entity.Post;
import com.agriconnect.backend.repository.PostRepository;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin
public class PostController {

    @Autowired
    private PostRepository repo;

    // ✅ PUBLIC POSTS
    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return repo.save(post);
    }

    // ✅ FARMERS SEE ALL POSTS
    @GetMapping
    public List<Post> getAllPosts() {
        return repo.findAll();
    }
}