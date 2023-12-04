package com.example.NutriTrack.controllers;

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
    public ModelAndView showRegistrationForm(){
        ModelAndView mav = new ModelAndView("register");
        mav.addObject("user", new User());
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