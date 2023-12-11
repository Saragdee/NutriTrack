package com.example.NutriTrack.domain;

import java.util.HashMap;
import java.util.Map;

public class RecommendedDosages {
    private static final Map<Integer, DosageInfo> recommendedDosages = new HashMap<>();

    public void initializeRecommendedDosages() {
        recommendedDosages.put(301, new DosageInfo("Calcium, Ca", "mg", 1000f));
        recommendedDosages.put(303, new DosageInfo("Iron, Fe", "mg", 18f));
        recommendedDosages.put(324, new DosageInfo("Vitamin D", "IU", 600f));
        recommendedDosages.put(304, new DosageInfo("Magnesium, Mg", "mg", 400f));
        recommendedDosages.put(291, new DosageInfo("Dietary Fiber", "g", 25f));
        recommendedDosages.put(306, new DosageInfo("Potassium, K", "mg", 4700f));
        recommendedDosages.put(307, new DosageInfo("Sodium, Na", "mg", 2300f));
        recommendedDosages.put(305, new DosageInfo("Phosphorus, P", "mg", 700f));
        recommendedDosages.put(315, new DosageInfo("Manganese, Mn", "mg", 2.3f));
        recommendedDosages.put(309, new DosageInfo("Zinc, Zn", "mg", 11f));
        recommendedDosages.put(401, new DosageInfo("Vitamin C", "mg", 90f));
        recommendedDosages.put(404, new DosageInfo("Thiamin", "mg", 1.2f));
        recommendedDosages.put(405, new DosageInfo("Riboflavin", "mg", 1.3f));
        recommendedDosages.put(406, new DosageInfo("Niacin", "mg", 16f));
        recommendedDosages.put(415, new DosageInfo("Vitamin B-6", "mg", 1.7f));
        recommendedDosages.put(410, new DosageInfo("Pantothenic acid", "mg", 5f));
        recommendedDosages.put(418, new DosageInfo("Vitamin B-12", "µg", 2.4f));
        recommendedDosages.put(430, new DosageInfo("Vitamin K", "µg", 120f));
        recommendedDosages.put(601, new DosageInfo("Cholesterol", "mg", 300f));
        recommendedDosages.put(318, new DosageInfo("Vitamin A (as IU)", "IU", 900f));
        recommendedDosages.put(320, new DosageInfo("Vitamin A (as RAE)", "µg", 700f));
        recommendedDosages.put(317, new DosageInfo("Selenium", "µg", 55f));
    }

    public static RecommendedDosages.DosageInfo getDosageInfo(int key) {
        return recommendedDosages.get(key);
    }

    public RecommendedDosages() {
        initializeRecommendedDosages();
    }

    public static class DosageInfo {
        private String name;
        private String unit;
        private float dosage;

        public DosageInfo(String name, String unit, float dosage) {
            this.name = name;
            this.unit = unit;
            this.dosage = dosage;
        }

        public String getName() {
            return name;
        }

        public String getUnit() {
            return unit;
        }

        public float getDosage() {
            return dosage;
        }
    }
}
