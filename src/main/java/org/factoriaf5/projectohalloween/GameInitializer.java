package org.factoriaf5.projectohalloween;

import org.factoriaf5.projectohalloween.model.Aiden;
import org.factoriaf5.projectohalloween.model.Backpack;
import org.factoriaf5.projectohalloween.model.Enchanted_Sword;
import org.factoriaf5.projectohalloween.model.Health_Potion;
import org.factoriaf5.projectohalloween.model.Magic_Amulet;
import org.factoriaf5.projectohalloween.service.AidenService;
import org.factoriaf5.projectohalloween.service.BackpackService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GameInitializer implements CommandLineRunner {

    private final AidenService aidenService;
    private final BackpackService backpackService;

    public GameInitializer(AidenService aidenService, BackpackService backpackService) {
        this.aidenService = aidenService;
        this.backpackService = backpackService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Crear un Aiden
        Aiden aiden = new Aiden("Aiden", 100, 20, 0);
        aidenService.createAiden(aiden);

        // Crear la mochila para Aiden
        Backpack backpack = new Backpack(aiden);
        backpackService.createBackpack(backpack);

        // Agregar objetos a la mochila de Aiden
        backpack.addItem(new Enchanted_Sword());
        backpack.addItem(new Health_Potion());
        backpack.addItem(new Magic_Amulet());

        // Guardar los cambios de la mochila
        backpackService.save(backpack);

        System.out.println("Juego inicializado con Aiden y su mochila.");
    }
}