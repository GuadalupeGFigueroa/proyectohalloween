package org.factoriaf5.projectohalloween.controller;

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

    public AidenController(AidenService aidenService) {
        this.aidenService = aidenService;
    }

    @GetMapping
    public List <Aiden> getAllAiden() {
        return aidenService.getAllAiden();
    }

    @GetMapping("/{id}")
    public ResponseEntity <Aiden> getAidenById(@PathVariable Long id) {
        return aidenService.getAidenById(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aiden createAiden(@RequestBody Aiden aiden){
        return aidenService.createAiden(aiden);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aiden> updateAiden(@PathVariable Long id, @RequestBody Aiden aidenDetails) {
        return aidenService.updateAiden(id, aidenDetails)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAiden(@PathVariable Long id) {
        if(aidenService.deleteAiden(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }



}
