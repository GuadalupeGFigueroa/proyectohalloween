package org.factoriaf5.projectohalloween.repository;

import org.factoriaf5.projectohalloween.model.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface StageRepository extends JpaRepository<Stage, Long> {
    Optional<Stage> findbyName(String name);
}