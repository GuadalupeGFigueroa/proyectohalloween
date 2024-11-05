package org.factoriaf5.projectohalloween.repository;

import org.factoriaf5.projectohalloween.model.SkeletonGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkeletonGroupRepository extends JpaRepository<SkeletonGroup, Long> {
}