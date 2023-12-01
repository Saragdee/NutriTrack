package com.example.NutriTrack;

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
        Users n = new Users();
        n.setUsername(name);
        userRepository.save(n);
        return "Saved";
    }
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Users> getAllUsers(){
        return userRepository.findAll();
    }
}
