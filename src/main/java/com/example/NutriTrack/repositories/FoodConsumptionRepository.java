package com.example.NutriTrack.repositories;


import com.example.NutriTrack.entities.FoodConsumption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodConsumptionRepository extends JpaRepository<FoodConsumption, Integer> {
    // Add custom query methods if needed
    @Query(value = "SELECT attr_id, ROUND(SUM(CAST(sup_quant AS DOUBLE)), 2) FROM foodconsumption GROUP BY attr_id", nativeQuery = true)
    List<Object[]> calculateSumOfSupQuantByAttrId();
}