package com.example.NutriTrack.service;

import com.example.NutriTrack.repositories.FoodConsumptionRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FoodConsumptionService {

    private final FoodConsumptionRepository foodConsumptionRepository;

    public FoodConsumptionService(FoodConsumptionRepository foodConsumptionRepository) {
        this.foodConsumptionRepository = foodConsumptionRepository;
    }

    public Map<Integer, Double> calculateDosageByAttrId() {
        List<Object[]> results = foodConsumptionRepository.calculateSumOfSupQuantByAttrId();
        Map<Integer, Double> dosageMap = new HashMap<>();

        for (Object[] result : results) {
            Integer attrId = (Integer) result[0];
            Double sumSupQuant = result[1] != null ? (Double) result[1] : 0.0;
            dosageMap.put(attrId, sumSupQuant);
        }

        return dosageMap;
    }

}


