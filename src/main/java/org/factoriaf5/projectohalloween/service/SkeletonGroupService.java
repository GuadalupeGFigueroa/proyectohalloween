package org.factoriaf5.projectohalloween.service;

import java.util.List;
import java.util.Optional;

import org.factoriaf5.projectohalloween.model.SkeletonGroup;
import org.factoriaf5.projectohalloween.repository.SkeletonGroupRepository;
import org.springframework.stereotype.Service;

@Service
public class SkeletonGroupService {
    private final SkeletonGroupRepository repository;

    public SkeletonGroupService(SkeletonGroupRepository repository) {
        this.repository = repository;
    }

    public List<SkeletonGroup> getAllSkeletonGroups() {
        return repository.findAll();
    }

    public Optional<SkeletonGroup> getSkeletonGroupById(Long id) {
        return repository.findById(id);
    }

    public SkeletonGroup createSkeletonGroup(SkeletonGroup skeletonGroup) {
        return repository.save(skeletonGroup);
    }

    public Optional<SkeletonGroup> updateSkeletonGroup(Long id, SkeletonGroup skeletonGroupDetails) {
        return repository.findById(id).map(existingGroup -> {
            existingGroup.setSkeletons(skeletonGroupDetails.getSkeletons());
            return repository.save(existingGroup);
        });
    }

    public boolean deleteSkeletonGroup(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}