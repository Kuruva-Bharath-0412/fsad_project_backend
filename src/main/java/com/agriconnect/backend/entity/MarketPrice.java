package com.agriconnect.backend.entity;

import jakarta.persistence.*;

@Entity
public class MarketPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cropName;
    private double price;

    // ✅ GETTERS
    public Long getId() {
        return id;
    }

    public String getCropName() {
        return cropName;
    }

    public double getPrice() {
        return price;
    }

    // ✅ SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setCropName(String cropName) {
        this.cropName = cropName;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}