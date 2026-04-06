package com.agriconnect.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "scheme")
public class Scheme {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String link;

    // getters & setters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLink() {
        return link;
    }
}