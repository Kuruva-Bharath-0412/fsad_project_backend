
package com.agriconnect.backend.entity;

import jakarta.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String expertEmail;
    private String answer;

    // ✅ GETTERS
    public Long getId() {
        return id;
    }

    public String getExpertEmail() {
        return expertEmail;
    }

    public String getAnswer() {
        return answer;
    }

    // ✅ SETTERS
    public void setId(Long id) {
        this.id = id;
    }

    public void setExpertEmail(String expertEmail) {
        this.expertEmail = expertEmail;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}