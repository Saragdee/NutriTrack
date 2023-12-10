package com.example.NutriTrack.repositories;


import com.example.NutriTrack.entities.FoodConsumption;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodConsumptionRepository extends JpaRepository<FoodConsumption, Integer> {
    // Add custom query methods if needed
}