package org.factoriaf5.projectohalloween.service;

import java.util.Optional;

import org.factoriaf5.projectohalloween.model.Backpack;
import org.factoriaf5.projectohalloween.model.GameObject;
import org.factoriaf5.projectohalloween.repository.BackpackRepository;
import org.springframework.stereotype.Service;

@Service
public class BackpackService {
    private final BackpackRepository backpackRepository;

    public BackpackService(BackpackRepository backpackRepository) {
        this.backpackRepository = backpackRepository;
    }

    public boolean addItemToBackpack(Long backpackId, GameObject item) {
        Optional<Backpack> backpackOpt = findBackpackById(backpackId);
        if (backpackOpt.isPresent()) {
            Backpack backpack = backpackOpt.get();
            if (backpack.addItem(item)) {
                save(backpack);
                return true;
            }
        }
        return false;
    }

    public boolean removeItemFromBackpack(Long backpackId, GameObject item) {
        Optional<Backpack> backpackOpt = findBackpackById(backpackId);
        if (backpackOpt.isPresent()) {
            Backpack backpack = backpackOpt.get();
            if (backpack.removeItem(item)) {
                save(backpack);
                return true;
            }
        }
        return false;
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