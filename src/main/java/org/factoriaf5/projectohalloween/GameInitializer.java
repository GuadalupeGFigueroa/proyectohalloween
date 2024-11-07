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

        Aiden aiden = new Aiden("Aiden", 100, 20, 0);
        aidenService.createAiden(aiden);

        Backpack backpack = new Backpack(aiden);
        backpackService.createBackpack(backpack);

        backpack.addItem(new Enchanted_Sword());
        backpack.addItem(new Health_Potion());
        backpack.addItem(new Magic_Amulet());

        backpackService.save(backpack);

        System.out.println("Juego inicializado con Aiden y su mochila.");
    }
}