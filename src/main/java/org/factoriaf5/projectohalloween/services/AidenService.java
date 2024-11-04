package org.factoriaf5.projectohalloween.services;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AidenService {
    private final AidenRepository repository;

    public AidenService(AidenRepository repository) {
        this.repository = repository;
    }

    public List <Aiden> getAllAiden(){
         return repository.findAll();
    }

    public Aiden getAidenById(Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Aiden's not found with id: " +id));
    }

    public Aiden createAiden(Aiden aiden) {
        return repository.save(aiden);
    }
    
    public Aiden updateAiden(Long id, Aiden aidenDetails) {
        Aiden aiden = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Aiden's not found with id: " +id));

        aiden.setName(aidenDetails.getName());
        aiden.setLife_points(aidenDetails.getLife_points());
        aiden.setAttack_power(aidenDetails.getAttack_power());
        aiden.setLevel(aidenDetails.getLevel());
        aiden.setExperience(aidenDetails.getExperience());
        aiden.setScore(aidenDetails.getScore());

        return repository.save(aiden);
    }

    public boolean deleteAiden(Long id) {
        Aiden aiden = repository.findById(id)
        .orElseThrow(() -> new RuntimeException("Aiden's not found with id: " +id));

        repository.delete(Aiden);
        return true;
    }
}




    
    

    
    
}
