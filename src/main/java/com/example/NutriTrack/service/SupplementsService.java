package com.example.NutriTrack.service;
import com.example.NutriTrack.entities.SupplementModel;
import com.example.NutriTrack.repositories.SupplementsRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SupplementsService {

    private final SupplementsRepository supplementsRepository;

    public SupplementsService(SupplementsRepository supplementsRepository) {
        this.supplementsRepository = supplementsRepository;
    }

    public List<SupplementModel> getAllSupplements() {
        List<SupplementModel> supplements = supplementsRepository.findAll();
        System.out.println("Fetched " + supplements.size() + " supplements from the database");
        return supplements;
    }
}
