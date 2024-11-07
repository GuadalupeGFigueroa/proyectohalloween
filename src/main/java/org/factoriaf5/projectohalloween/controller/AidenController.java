package org.factoriaf5.projectohalloween.controller;

import java.util.List;

import org.factoriaf5.projectohalloween.model.Aiden;
import org.factoriaf5.projectohalloween.model.Backpack;
import org.factoriaf5.projectohalloween.model.GameObject;
import org.factoriaf5.projectohalloween.service.AidenService;
import org.factoriaf5.projectohalloween.service.BackpackService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aiden")
public class AidenController {
    private final AidenService aidenService;
    private final BackpackService backpackService;

    public AidenController(AidenService aidenService, BackpackService backpackService) {
        this.aidenService = aidenService;
        this.backpackService = backpackService;
    }

    @GetMapping
    public List<Aiden> getAllAiden() {
        return aidenService.getAllAiden();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aiden> getAidenById(@PathVariable Long id) {
        try {
            Aiden aiden = aidenService.getAidenById(id);
            return ResponseEntity.ok(aiden);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public Aiden createAiden(@RequestBody Aiden aiden) {
        return aidenService.createAiden(aiden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aiden> updateAiden(@PathVariable Long id, @RequestBody Aiden aidenDetails) {
        try {
            Aiden updatedAiden = aidenService.updateAiden(id, aidenDetails);
            return ResponseEntity.ok(updatedAiden);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAiden(@PathVariable Long id) {
        try {
            if (aidenService.deleteAiden(id)) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}/backpack/add-item")
    public ResponseEntity<Backpack> addItemToBackpack(@PathVariable Long id, @RequestBody GameObject item) {
        try {
            Aiden aiden = aidenService.getAidenById(id);
            Backpack backpack = aiden.getBackpack();
            if (backpack.addItem(item)) {
                backpackService.save(backpack);
                return ResponseEntity.ok(backpack);
            } else {
                return ResponseEntity.badRequest().body(backpack);
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}/backpack/remove-item")
    public ResponseEntity<Backpack> removeItemFromBackpack(@PathVariable Long id, @RequestBody GameObject item) {
        try {
            Aiden aiden = aidenService.getAidenById(id);
            Backpack backpack = aiden.getBackpack();
            if (backpack.removeItem(item)) {
                backpackService.save(backpack);
                return ResponseEntity.ok(backpack);
            } else {
                return ResponseEntity.badRequest().body(backpack);
            }
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}