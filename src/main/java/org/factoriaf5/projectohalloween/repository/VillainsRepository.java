package org.factoriaf5.projectohalloween.repository;

import org.factoriaf5.projectohalloween.model.Villains;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VillainsRepository extends JpaRepository<Villains, Long> {
}
