package com.example.NutriTrack.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NutrientInfo {

    private static final Map<Integer, Nutrient> nutrientInfo = new HashMap<>();

    private void initializeNutrientInfo() {
        nutrientInfo.put(301, new Nutrient("Calcium, Ca", 0.0f));
        nutrientInfo.put(303, new Nutrient("Iron, Fe", 0.0f));
        nutrientInfo.put(324, new Nutrient("Vitamin D", 0.0f));
        nutrientInfo.put(304, new Nutrient("Magnesium, Mg", 0.0f));
        nutrientInfo.put(291, new Nutrient("Dietary Fiber", 0.0f));
        nutrientInfo.put(306, new Nutrient("Potassium, K", 0.0f));
        nutrientInfo.put(307, new Nutrient("Sodium, Na", 0.0f));
        nutrientInfo.put(305, new Nutrient("Phosphorus, P", 0.0f));
        nutrientInfo.put(315, new Nutrient("Manganese, Mn", 0.0f));
        nutrientInfo.put(309, new Nutrient("Zinc, Zn", 0.0f));
        nutrientInfo.put(401, new Nutrient("Vitamin C", 0.0f));
        nutrientInfo.put(404, new Nutrient("Thiamin", 0.0f));
        nutrientInfo.put(405, new Nutrient("Riboflavin", 0.0f));
        nutrientInfo.put(406, new Nutrient("Niacin", 0.0f));
        nutrientInfo.put(415, new Nutrient("Vitamin B-6", 0.0f));
        nutrientInfo.put(410, new Nutrient("Pantothenic acid", 0.0f));
        nutrientInfo.put(418, new Nutrient("Vitamin B-12", 0.0f));
        nutrientInfo.put(430, new Nutrient("Vitamin K", 0.0f));
        nutrientInfo.put(601, new Nutrient("Cholesterol", 0.0f));
        nutrientInfo.put(318, new Nutrient("Vitamin A (as IU)", 0.0f));
        nutrientInfo.put(320, new Nutrient("Vitamin A (as RAE)", 0.0f));
        nutrientInfo.put(317, new Nutrient("Selenium", 0.0f));
    }

    public static Nutrient getNutrientInfo(int key) {
        return nutrientInfo.get(key);
    }

    public NutrientInfo() {
        initializeNutrientInfo();
    }

    // Method to get all keys in the nutrientInfo map
    public Set<Integer> getAllKeys() {
        return nutrientInfo.keySet();
    }

    // Method to update the value of a nutrient by key
    public void updateNutrientValue(int key, float additionalValue) {
        Nutrient nutrient = nutrientInfo.get(key);
        if (nutrient != null) {
            nutrient.addToValue(additionalValue);
        } else {
            // Handle the case where the nutrient with the given key is not found
        }
    }

    public Map<String, Float> getNutrientInfoAsMap() {
        Map<String, Float> nutrientMap = new HashMap<>();
        for (Map.Entry<Integer, Nutrient> entry : nutrientInfo.entrySet()) {
            nutrientMap.put(entry.getValue().getName(), entry.getValue().getValue());
        }
        return nutrientMap;
    }

    public static class Nutrient {
        private String name;
        private float value;

        public Nutrient(String name, float value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public float getValue() {
            return value;
        }

        public void setValue(float value) {
            this.value = value;
        }

        public void addToValue(float additionalValue) {
            this.value += additionalValue;
        }
    }
}
