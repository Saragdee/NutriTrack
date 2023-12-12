package com.example.NutriTrack.repositories;

import com.example.NutriTrack.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
}