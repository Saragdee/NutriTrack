package com.example.NutriTrack.controllers;

import ch.qos.logback.core.model.Model;
import com.example.NutriTrack.entities.FoodConsumption;
import com.example.NutriTrack.entities.User;
import com.example.NutriTrack.repositories.UserRepository;
import com.example.NutriTrack.repositories.FoodConsumptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ReportController {

    @Autowired
    private FoodConsumptionRepository foodConsumptionRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/reports")
    public String showReportsPage(Model model) {
        // Fetch data from the foodconsumption and users tables
        List<FoodConsumption> foodConsumptions = foodConsumptionRepository.findAll();
        Iterable<User> users = userRepository.findAll();

        // Add fetched data to the model to be used in the Thymeleaf template
        model.addText("foodConsumptions");
        model.addText("users");

        // Return the reports.html Thymeleaf template
        return "reports";
    }
}
