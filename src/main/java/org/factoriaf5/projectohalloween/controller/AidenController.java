package org.factoriaf5.projectohalloween.controller;

import java.util.List;

import org.factoriaf5.projectohalloween.model.Aiden;
import org.factoriaf5.projectohalloween.service.AidenService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aidens")
public class AidenController {
    private final AidenService aidenService;

    public AidenController(AidenService aidenService) {
        this.aidenService = aidenService;
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

    public class AidenNotFoundException extends RuntimeException {
        public AidenNotFoundException(Long id) {
            super("Aiden with ID " + id + " not found.");
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
}
