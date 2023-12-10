package com.example.NutriTrack.repo;


import com.example.NutriTrack.model.FoodConsumption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FoodConsumptionRepository extends JpaRepository<FoodConsumption, Integer> {
    // Add custom query methods if needed
}