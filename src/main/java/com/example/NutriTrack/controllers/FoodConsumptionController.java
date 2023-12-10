package com.example.NutriTrack.controllers;


import com.example.NutriTrack.domain.FoodConsumptionRequest;
import com.example.NutriTrack.entities.FoodConsumption;
import com.example.NutriTrack.mapper.FoodConsumptionMapper;
import com.example.NutriTrack.repositories.FoodConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FoodConsumptionController {

    @Autowired
    private FoodConsumptionRepository foodConsumptionRepository;

    @GetMapping("/logfood")//logfood
    public String showForm(Model model) {
        // Create a new instance of FoodConsumption and add it to the model
        FoodConsumption foodConsumption = new FoodConsumption(); // Or fetch from a service/DB
        model.addAttribute("foodConsumption", foodConsumption);
        return "dailyintake"; // The name of your Thymeleaf template for the form
    }
    @PostMapping("/logfood")
    public String submitForm(@RequestBody List<FoodConsumptionRequest> foodConsumptionRequestList) {
        List<FoodConsumption> foodConsumptionList = new ArrayList<>();
        for (FoodConsumptionRequest foodConsumptionRequest : foodConsumptionRequestList) {
            FoodConsumption foodConsumption = FoodConsumptionMapper.mapToFoodConsumption(foodConsumptionRequest);
            foodConsumptionList.add(FoodConsumptionMapper.mapToFoodConsumption(foodConsumptionRequest));

        }

        foodConsumptionRepository.saveAll(foodConsumptionList);

        // Your logic to save data or perform operations based on 'request'
        return "dailyintake"; // Return the appropriate view
    }

}