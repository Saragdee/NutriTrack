package com.example.NutriTrack.controllers;


import com.example.NutriTrack.model.FoodConsumption;
import com.example.NutriTrack.repo.FoodConsumptionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FoodConsumptionController {

    @Autowired
    private FoodConsumptionRepository foodConsumptionRepository;

    @GetMapping("/showForm")
    public String showForm(Model model) {
        // Create a new instance of FoodConsumption and add it to the model
        FoodConsumption foodConsumption = new FoodConsumption(); // Or fetch from a service/DB
        model.addAttribute("foodConsumption", foodConsumption);
        return "dailyintake"; // The name of your Thymeleaf template for the form
    }
    @ModelAttribute("foodConsumption")
    public FoodConsumption foodConsumption() {
        return new FoodConsumption();
    }
    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute("foodConsumption") FoodConsumption foodConsumption, BindingResult bindingResult, Model model) {
        model.addAttribute("foodConsumption", foodConsumption);
        FoodConsumption savedFoodConsumption = foodConsumptionRepository.save(foodConsumption);
        // Additional operations if needed (e.g., data manipulation, validation, etc.)
        // ...
        if(bindingResult.hasErrors()){
            System.out.println("There was a error "+bindingResult);

            return "index";
        }
        // Add attributes to the model for the view
        model.addAttribute("savedFoodConsumption", savedFoodConsumption);
        model.addAttribute("message", "Form submitted successfully!");

        return "success"; // Return the appropriate view
    }

}