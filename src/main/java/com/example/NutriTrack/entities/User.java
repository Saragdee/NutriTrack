package com.example.NutriTrack.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer UserID;

    private String username;

    private String password;

    private Integer weight;

    private String gender;

    private String location;


    private String activityLevel;

    private String allergies;

    private String supplements;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Recommendation> recommendations;
//
//    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
//    private Set<Report> reports;

}
