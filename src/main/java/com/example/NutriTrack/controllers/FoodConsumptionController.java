package com.example.NutriTrack.controllers;


import com.example.NutriTrack.model.FoodConsumption;
import com.example.NutriTrack.repo.FoodConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String submitForm(@ModelAttribute("foodConsumption") FoodConsumption foodConsumption) {
        System.out.println(foodConsumption);
        foodConsumptionRepository.save(foodConsumption);
        return "dailyintake"; // Return the appropriate view
    }

}