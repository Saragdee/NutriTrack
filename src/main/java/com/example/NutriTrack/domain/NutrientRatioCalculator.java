package com.example.NutriTrack.domain;

import java.util.HashMap;
import java.util.Map;

public class NutrientRatioCalculator {

    public static Map<String, Float> calculateNutrientRatio(NutrientInfo nutrientInfo, RecommendedDosages recommendedDosages, int numberOfDays) {
        Map<String, Float> ratioMap = new HashMap<>();

        for (Integer key : nutrientInfo.getAllKeys()) {
            NutrientInfo.Nutrient nutrient = nutrientInfo.getNutrientInfo(key);
            RecommendedDosages.DosageInfo dosageInfo = recommendedDosages.getDosageInfo(key);

            if (nutrient != null && dosageInfo != null && dosageInfo.getDosage() != 0) {
                float adjustedDosage = dosageInfo.getDosage() * numberOfDays;
                float ratio = nutrient.getValue() / adjustedDosage * 100.0f;
                ratioMap.put(nutrient.getName(), ratio);
            } else {
                // Handle the case where either the nutrient or dosage information is not available
            }
        }

        return ratioMap;
    }
}
