package com.example.NutriTrack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
public @Data class Users {
    @Id
    @GeneratedValue
    private Integer id;

    private String username;

    private String password;

    private Integer weight;

    private String gender;

    private String location;

    public void setUsername(String name) {
    }
}
