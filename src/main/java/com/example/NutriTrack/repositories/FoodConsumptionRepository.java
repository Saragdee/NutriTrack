package com.example.NutriTrack.repositories;


import com.example.NutriTrack.entities.FoodConsumption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface FoodConsumptionRepository extends JpaRepository<FoodConsumption, Integer> {
    List<FoodConsumption> findByDateBetween(LocalDate startDate, LocalDate endDate);
}