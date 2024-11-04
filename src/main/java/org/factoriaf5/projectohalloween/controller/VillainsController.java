package org.factoriaf5.projectohalloween.controller;

import org.factoriaf5.projectohalloween.model.Villains;
import org.factoriaf5.projectohalloween.service.VillainsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/villains")
public class VillainsController {

    private final VillainsService villainsService;

    public VillainsController(VillainsService villainsService) {
        this.villainsService = villainsService;
    }

    @GetMapping
    public List<Villains> getAllVillains() {
        return villainsService.getAllVillains();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Villains> getVillainById(@PathVariable Long id) {
        return villainsService.getVillainById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Villains createVillain(@RequestBody Villains villain) {
        return villainsService.createVillain(villain);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Villains> updateVillain(@PathVariable Long id, @RequestBody Villains villainDetails) {
        return villainsService.updateVillain(id, villainDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVillain(@PathVariable Long id) {
        if (villainsService.deleteVillain(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}


