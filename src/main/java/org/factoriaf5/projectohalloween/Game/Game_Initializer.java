package org.factoriaf5.projectohalloween;

import org.factoriaf5.projectohalloween.model.Ability;
import org.factoriaf5.projectohalloween.model.Aiden;
import org.factoriaf5.projectohalloween.model.Ghost;
import org.factoriaf5.projectohalloween.model.SkeletonGroup;
import org.factoriaf5.projectohalloween.model.Stage;
import org.factoriaf5.projectohalloween.model.Vampire;
import org.factoriaf5.projectohalloween.model.Villains;
import org.factoriaf5.projectohalloween.repository.AidenRepository;
import org.factoriaf5.projectohalloween.repository.StageRepository;
import org.factoriaf5.projectohalloween.repository.VillainsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Game_Initializer {

    @Autowired
    private AidenRepository aidenRepository; // Asumiendo que tienes un repositorio para Aiden
    @Autowired
    private AbilityRepository abilityRepository; // Repositorio de habilidades
    @Autowired
    private VillainsRepository VillainsRepository; // Repositorio de villanos
    @Autowired
    private StageRepository StageRepository; // Repositorio de etapas

    @PostConstruct
    public void initGameData() {
        // Crear habilidades
        Ability powerfulBlow = new Ability("Powerful Blow", "Attack Boost", "Increases attack damage by 20%", 2, 3);
        Ability protectiveShield = new Ability("Protective Shield", "Defense Shield", "Reduces incoming damage by 15%",
                3, 2);

        // Guardar habilidades en la base de datos
        abilityRepository.save(powerfulBlow);
        abilityRepository.save(protectiveShield);

        // Crear Aiden con habilidades
        Aiden aiden = new Aiden("Aiden", 100, 20, 0);
        aiden.addAbility(powerfulBlow);
        aiden.addAbility(protectiveShield);

        // Guardar Aiden en la base de datos
        AidenRepository.save(aiden);

        // Crear enemigos
        Villains ghost = new Ghost();
        Villains skeletonGroup = new SkeletonGroup(3);
        Villains vampire = new Vampire();

        // Guardar villanos en la base de datos
        VillainsRepository.save(ghost);
        VillainsRepository.save(skeletonGroup);
        VillainsRepository.save(vampire);

        // Crear etapa inicial
        Stage stage1 = new Stage("Haunted Forest", "A spooky forest filled with ghosts and skeletons.", 1);
        StageRepository.save(stage1);
    }
}