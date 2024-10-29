package org.factoriaf5.projectohalloween.repository;  

import org.factoriaf5.projectohalloween.model.Aiden; 
import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.stereotype.Repository; 

@Repository 
public interface AidenRepository extends JpaRepository<Aiden, Long> { 
    
}
