package com.example.NutriTrack.mapper;

import com.example.NutriTrack.domain.FoodConsumptionRequest;
import com.example.NutriTrack.entities.FoodConsumption;

public class FoodConsumptionMapper {

    public static FoodConsumption mapToFoodConsumption(FoodConsumptionRequest request) {
        FoodConsumption foodConsumption = new FoodConsumption();

        // Map attributes from FoodConsumptionRequest to FoodConsumption
        foodConsumption.setDate(request.getDate());
        foodConsumption.setAttrId(Long.valueOf(request.getAttrId()));
        foodConsumption.setValue(request.getValue());

        return foodConsumption;
    }
}
