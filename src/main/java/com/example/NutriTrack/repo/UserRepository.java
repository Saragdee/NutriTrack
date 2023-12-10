package com.example.NutriTrack.repo;

import com.example.NutriTrack.model.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Integer> {

}
