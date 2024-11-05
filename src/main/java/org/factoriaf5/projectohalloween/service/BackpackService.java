package org.factoriaf5.projectohalloween.service;

import java.util.Optional;

import org.factoriaf5.projectohalloween.model.Backpack;
import org.factoriaf5.projectohalloween.repository.BackpackRepository;
import org.springframework.stereotype.Service;

@Service
public class BackpackService {
    private final BackpackRepository backpackRepository;

    public BackpackService(BackpackRepository backpackRepository) {
        this.backpackRepository = backpackRepository;
    }

    public Backpack createBackpack(Backpack backpack) {
        return backpackRepository.save(backpack);
    }

    public Optional<Backpack> findBackpackById(Long id) {
        return backpackRepository.findById(id);
    }

    public Backpack save(Backpack backpack) {
        return backpackRepository.save(backpack);
    }

    public void deleteBackpack(Long id) {
        backpackRepository.deleteById(id);
    }
}