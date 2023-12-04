package com.example.NutriTrack.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

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
    @GetMapping("/favicon.ico")
    @ResponseBody
    public void returnNoFavicon() {
        // Throw a ResponseStatusException with HTTP 404 status for favicon not found
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Favicon not found");
    }
}
