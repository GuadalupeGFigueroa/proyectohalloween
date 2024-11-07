package org.factoriaf5.projectohalloween.controller;

import org.factoriaf5.projectohalloween.model.Backpack;
import org.factoriaf5.projectohalloween.service.BackpackService;
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
@RequestMapping("/api/backpack")
public class BackpackController {
    private final BackpackService backpackService;

    public BackpackController(BackpackService backpackService) {
        this.backpackService = backpackService;
    }

    @PostMapping
    public ResponseEntity<Backpack> createBackpack(@RequestBody Backpack backpack) {
        return ResponseEntity.ok(backpackService.createBackpack(backpack));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Backpack> getBackpack(@PathVariable Long id) {
        return backpackService.findBackpackById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}/add-item")
    public ResponseEntity<Backpack> addItem(@PathVariable Long id,
            @RequestBody org.factoriaf5.projectohalloween.model.GameObject item) {
        return backpackService.findBackpackById(id).map(backpack -> {
            if (backpack.addItem(item)) {
                backpackService.save(backpack);
                return ResponseEntity.ok(backpack);
            } else {
                return ResponseEntity.badRequest().body(backpack);
            }
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBackpack(@PathVariable Long id) {
        backpackService.deleteBackpack(id);
        return ResponseEntity.noContent().build();
    }
}