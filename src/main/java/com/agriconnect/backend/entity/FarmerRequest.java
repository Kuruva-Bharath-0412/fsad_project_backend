package com.agriconnect.backend.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class FarmerRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String message;
    private LocalDateTime createdAt = LocalDateTime.now();

    // ✅ getters & setters
    public Long getId() { return id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}