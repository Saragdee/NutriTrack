package com.example.NutriTrack.service;//import com.example.NutriTrack.repositories.UserRepository;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;

//@Service
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        com.example.NutriTrack.entities.User user = userRepository.findb
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
//
//        return new User(user.getUsername(), user.getPassword(), new ArrayList<>());
//    }
//}
