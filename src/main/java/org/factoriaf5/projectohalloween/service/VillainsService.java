package org.factoriaf5.projectohalloween.service;
import org.factoriaf5.projectohalloween.model.Villains;
import org.factoriaf5.projectohalloween.repository.VillainsRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VillainsService {
    
    private final VillainsRepository villainsRepository;

   
    public VillainsService(VillainsRepository villainsRepository) {
        this.villainsRepository = villainsRepository;
    }

    public List<Villains> getAllVillains() {
        return villainsRepository.findAll();
    }

    public Optional<Villains> getVillainById(Long id) {
        return villainsRepository.findById(id);
    }

    public Villains createVillain(Villains villain) {
        return villainsRepository.save(villain);
    }

    public Optional<Villains> updateVillain(Long id, Villains villainDetails) {
        return villainsRepository.findById(id).map(villain -> {
            villain.setLife_points(villainDetails.getLife_points());
            villain.setAttack_points(villainDetails.getAttack_points());
            return villainsRepository.save(villain);
        });
    }

    public boolean deleteVillain(Long id) {
        return villainsRepository.findById(id).map(villain -> {
            villainsRepository.delete(villain);
            return true;
        }).orElse(false);
    }
}