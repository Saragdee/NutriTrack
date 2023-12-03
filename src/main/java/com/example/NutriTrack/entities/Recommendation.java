package com.example.NutriTrack.entities;

import jakarta.persistence.*;

import java.util.Date;

public class Recommendation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer recomID;

    @Temporal(TemporalType.DATE)
    private Date recom_date;

    @Lob
    private String recom_content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private User user;

}
