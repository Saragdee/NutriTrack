package com.example.NutriTrack.mapper;

import com.example.NutriTrack.domain.FoodConsumptionRequest;
import com.example.NutriTrack.entities.FoodConsumption;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class FoodConsumptionMapper {
    public static FoodConsumption mapToFoodConsumption(FoodConsumptionRequest request) {
        FoodConsumption foodConsumption = new FoodConsumption();

        foodConsumption.setAttrId(Integer.valueOf(request.getAttrId()));

        try {
            Float value = Float.valueOf(request.getValue());
            foodConsumption.setValue(value);

            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("MM/dd/uuuu");
            LocalDate date = LocalDate.parse(request.getDate(), formatters);
            foodConsumption.setDate(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return foodConsumption;
    }
}
