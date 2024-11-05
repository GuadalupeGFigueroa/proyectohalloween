package org.factoriaf5.projectohalloween.controller;

import java.util.List;

import org.factoriaf5.projectohalloween.model.SkeletonGroup;
import org.factoriaf5.projectohalloween.service.SkeletonGroupService;
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
@RequestMapping("/skeleton-groups")
public class SkeletonGroupController {
    private final SkeletonGroupService skeletonGroupService;

    public SkeletonGroupController(SkeletonGroupService skeletonGroupService) {
        this.skeletonGroupService = skeletonGroupService;
    }

    @GetMapping
    public List<SkeletonGroup> getAllSkeletonGroups() {
        return skeletonGroupService.getAllSkeletonGroups();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SkeletonGroup> getSkeletonGroupById(@PathVariable Long id) {
        return skeletonGroupService.getSkeletonGroupById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SkeletonGroup createSkeletonGroup(@RequestBody SkeletonGroup skeletonGroup) {
        return skeletonGroupService.createSkeletonGroup(skeletonGroup);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SkeletonGroup> updateSkeletonGroup(@PathVariable Long id,
            @RequestBody SkeletonGroup skeletonGroupDetails) {
        return skeletonGroupService.updateSkeletonGroup(id, skeletonGroupDetails)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSkeletonGroup(@PathVariable Long id) {
        if (skeletonGroupService.deleteSkeletonGroup(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}