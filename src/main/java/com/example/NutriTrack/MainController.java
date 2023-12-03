package com.example.NutriTrack;

import com.example.NutriTrack.entities.User;
import com.example.NutriTrack.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired // get bean called userRepository
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public  @ResponseBody String addNewUser(@RequestParam String name){
        User n = new User();
        n.setUsername(name);
        userRepository.save(n);
        return "Saved";
    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
}
