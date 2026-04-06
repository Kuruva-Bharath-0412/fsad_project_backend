package com.agriconnect.backend.entity;

import jakarta.persistence.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;   // who posted
    private String message; // content

    // getters & setters
    public Long getId() { return id; }

    public String getEmail() { return email; }

    public String getMessage() { return message; }

    public void setId(Long id) { this.id = id; }

    public void setEmail(String email) { this.email = email; }

    public void setMessage(String message) { this.message = message; }
}