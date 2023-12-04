package com.example.NutriTrack.repo;


import com.example.NutriTrack.model.FoodConsumption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodConsumptionRepository extends JpaRepository<FoodConsumption, Long> {
    // Add custom query methods if needed
}