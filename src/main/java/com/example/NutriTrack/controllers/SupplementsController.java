package com.example.NutriTrack.controllers;


import com.example.NutriTrack.entities.SupplementModel;
import com.example.NutriTrack.service.FoodConsumptionService;
import com.example.NutriTrack.service.SupplementsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


@Controller
public class SupplementsController {

    private final SupplementsService supplementsService;
    private final FoodConsumptionService foodConsumptionService;

    public SupplementsController(SupplementsService supplementsService, FoodConsumptionService foodConsumptionService) {
        this.supplementsService = supplementsService;
        this.foodConsumptionService = foodConsumptionService;
    }

    @GetMapping("/reports")
    public String displaySupplements(Model model) {
        List<SupplementModel> supplements = supplementsService.getAllSupplements();
        Map<Integer, Double> dosageMap = foodConsumptionService.calculateDosageByAttrId();

        model.addAttribute("supplements", supplements);
        model.addAttribute("dosageMap", dosageMap);
        return "reports"; // This is the name of your HTML file
    }
}

