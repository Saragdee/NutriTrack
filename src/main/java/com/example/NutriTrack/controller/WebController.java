package com.example.NutriTrack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {
    @GetMapping("/")
    public String showAuthenticationPage() {
        //model.addAttribute("name", "");
        return "authentication"; // Returns the name of the HTML page without extension
    }
    @GetMapping("/{pageName}")
    public String showPage(@PathVariable String pageName, Model model) {
        // Here, the {pageName} variable will match any path segment and be used as the page name
        model.addAttribute("pageName", pageName);
        return "template"; // Return the name of the Thymeleaf template
    }
}
