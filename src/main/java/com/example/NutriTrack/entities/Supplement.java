package com.example.NutriTrack.entities;

import com.example.NutriTrack.entities.User;
import jakarta.persistence.*;

public class Supplement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer supplementID;

    private  String sup_name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private User user;
}
