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

    @GetMapping("/logfood")
    public String showForm(Model model) {
        FoodConsumption foodConsumption = new FoodConsumption();
        model.addAttribute("foodConsumption", foodConsumption);
        return "dailyintake";
    }
    @PostMapping("/logfood")
    public String submitForm(@RequestBody List<FoodConsumptionRequest> foodConsumptionRequestList, Model model) {
        List<FoodConsumption> foodConsumptionList = new ArrayList<>();
        for (FoodConsumptionRequest foodConsumptionRequest : foodConsumptionRequestList) {
            foodConsumptionList.add(FoodConsumptionMapper.mapToFoodConsumption(foodConsumptionRequest));
        }

        FoodConsumption foodConsumption = new FoodConsumption();
        model.addAttribute("foodConsumption", foodConsumption);

        foodConsumptionRepository.saveAll(foodConsumptionList);

        return "dailyintake";
    }

}