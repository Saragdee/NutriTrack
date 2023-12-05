package com.example.NutriTrack.controllers;

import ch.qos.logback.core.model.Model;
import com.example.NutriTrack.entities.User;
import com.example.NutriTrack.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/register")
    public ModelAndView showRegistrationForm(Model mopdel){
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new User());

        String[] allergies = {"Peanuts", "Shellfish", "Milk", "Eggs", "Soy", "Wheat", "Fish", "Tree nuts", "Gluten", "Sesame seeds", "Mustard", "Corn", "Lupin", "Celery"};
        String[] supplements = {"Vitamin D", "Vitamin C", "Calcium", "Iron", "Omega-3 Fatty Acids", "Probiotics", "Multivitamins", "Magnesium", "Zinc", "Biotin", "Melatonin", "Glucosamine"};

        mav.addObject("allergyList", allergies);
        mav.addObject("supplementList", supplements);

        return mav;
    }

    @PostMapping("/register")
    public String registerUser(User user){
        userRepository.save(user);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String registrationSuccess(){
        return "success";
    }


}