package com.example.NutriTrack.repositories;
import com.example.NutriTrack.entities.SupplementModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplementsRepository extends JpaRepository<SupplementModel, Integer> {
    // Define custom queries if needed
}
