package com.example.NutriTrack.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "allergies")
public class Allergy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer allergID;
    private String allerg_name;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private User user;
}
