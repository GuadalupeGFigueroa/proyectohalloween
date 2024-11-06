package org.factoriaf5.projectohalloween.config;

import org.factoriaf5.projectohalloween.model.Stage;
import org.factoriaf5.projectohalloween.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PostConstruct;

public class StageInitializer {

    private final StageRepository stageRepository;

    @Autowired
    public StageInitializer(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    @PostConstruct
    public void initializeStages() {
        Stage enchantedForest = new Stage("Bosque Encantado", "La primera zona y donde divulgan los esqueletos", 1);
        Stage forgottenCemetery = new Stage("Cementerio Olvidado",
                "La segunda zona y donde residen las almas de los atormentados...", 2);
        Stage mortisCastle = new Stage("El Castillo de Mortis", "La zona final y donde nuestro rival se asedia!", 3);

        stageRepository.save(enchantedForest);
        stageRepository.save(forgottenCemetery);
        stageRepository.save(mortisCastle);

        // Si necesitas incrementar el nivel de alguna etapa después de la creación,
        // puedes hacerlo aquí:
        enchantedForest.nextLevel(); // El bosque encantado sube de nivel, si lo deseas
        forgottenCemetery.nextLevel(); // El cementerio olvidado sube de nivel
    }
}