package com.example.NutriTrack.mapper;

import com.example.NutriTrack.domain.FoodConsumptionRequest;
import com.example.NutriTrack.entities.FoodConsumption;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FoodConsumptionMapper {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static FoodConsumption mapToFoodConsumption(FoodConsumptionRequest request) {
        FoodConsumption foodConsumption = new FoodConsumption();

        foodConsumption.setAttrId(Integer.valueOf(request.getAttrId()));

        try {
            Float value = Float.valueOf(request.getValue());
            foodConsumption.setValue(value);

            Date date = dateFormat.parse(request.getDate());
            foodConsumption.setDate(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return foodConsumption;
    }
}
