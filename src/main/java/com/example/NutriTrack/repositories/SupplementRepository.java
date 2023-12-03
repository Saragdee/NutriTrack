package com.example.NutriTrack.repositories;

import com.example.NutriTrack.entities.Supplement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplementRepository extends JpaRepository<Supplement, Integer> {
}
