package com.agriconnect.backend.entity;

import jakarta.persistence.*;

@Entity
public class FarmerReply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long requestId;
    private String farmerEmail;
    private String reply;

    // getters & setters
    public Long getId() { return id; }

    public Long getRequestId() { return requestId; }
    public void setRequestId(Long requestId) { this.requestId = requestId; }

    public String getFarmerEmail() { return farmerEmail; }
    public void setFarmerEmail(String farmerEmail) { this.farmerEmail = farmerEmail; }

    public String getReply() { return reply; }
    public void setReply(String reply) { this.reply = reply; }
}