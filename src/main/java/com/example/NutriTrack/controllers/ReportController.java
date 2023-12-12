package com.example.NutriTrack.controllers;

import com.example.NutriTrack.domain.NutrientInfo;
import com.example.NutriTrack.domain.NutrientRatioCalculator;
import com.example.NutriTrack.domain.RecommendedDosages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ReportController {

    @Autowired
    private FoodConsumptionRepository foodConsumptionRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/reports")
    public String showReportsPage(Model model) {
        // Add fetched data to the model to be used in the Thymeleaf template
        model.addAttribute("foodConsumptions");
        model.addAttribute("users");

        // Return the reports.html Thymeleaf template
        return "reports";
    }

    @PostMapping("/reports")
    @ResponseBody
    public Map<String, Object> generateReport(@RequestParam("selectedDate") String selectedDate,
                                              @RequestParam("reportDuration") String reportDuration,
                                              Model model) {

        LocalDate endDate = LocalDate.parse(selectedDate);
        LocalDate startDate = null;

        try {
            switch (reportDuration) {
                case "today":
                    startDate = endDate.minusDays(1);
                    break;
                case "week":
                    startDate = endDate.minusDays(7); // Assuming a week is 7 days
                    break;
                case "month":
                    startDate = endDate.minusMonths(1).minusDays(1); // Last day of the month
                    break;
                default:
                    throw new IllegalArgumentException("Invalid reportDuration" + reportDuration);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        int daysAsInteger = Math.toIntExact(daysBetween);

        // Fetch FoodConsumption records based on the date range
        List<FoodConsumption> foodConsumptions = foodConsumptionRepository.findByDateBetween(startDate, endDate);
        NutrientInfo nutrientInfo = new NutrientInfo();
        for (FoodConsumption foodConsumption : foodConsumptions) {
            nutrientInfo.updateNutrientValue(foodConsumption.getAttrId(), foodConsumption.getValue());
        }

        NutrientRatioCalculator nutrientRatioCalculator = new NutrientRatioCalculator();
        RecommendedDosages recommendedDosages = new RecommendedDosages();
        Map<String, Float> NutrientInfoNameValueMap = nutrientRatioCalculator.calculateNutrientRatio(nutrientInfo, recommendedDosages, daysAsInteger);

        // Create a map to hold the response data
        Map<String, Object> response = new HashMap<>();
        response.put("nutrientInfo", NutrientInfoNameValueMap);

        // Return the map, which will be automatically converted to JSON
        return response;
    }

}