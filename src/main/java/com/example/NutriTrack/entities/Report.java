package com.example.NutriTrack.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer reportID;

    @Temporal(TemporalType.DATE)
    private Date report_date;

    @Lob
    private String report_content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserID")
    private User user;

}
