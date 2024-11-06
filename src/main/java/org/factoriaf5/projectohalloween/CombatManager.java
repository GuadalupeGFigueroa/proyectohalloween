package org.factoriaf5.projectohalloween;

import java.util.List;

import org.factoriaf5.projectohalloween.model.Aiden;
import org.factoriaf5.projectohalloween.model.Health_Potion;
import org.factoriaf5.projectohalloween.model.Villains;

public class CombatManager {

    private Aiden player;
    private List<Villains> enemies;

    public CombatManager(Aiden player, List<Villains> enemies) {
        this.player = player;
        this.enemies = enemies;
    }

    public void startCombat() {
        while (!player.isDead() && !enemies.isEmpty()) {
            // Turno del héroe
            player.attack(enemies.get(0)); // Ataca al primer enemigo en la lista

            // Si el enemigo muere, lo elimina y deja una poción
            if (enemies.get(0).getLife_points() <= 0) {
                player.addItem(new Health_Potion()); // Deja una poción
                enemies.get(0).defeated(player); // Aumenta el puntaje o da efectos adicionales
                enemies.remove(0); // Elimina al enemigo derrotado
            }

            // Turno de los enemigos
            for (Villains enemy : enemies) {
                if (!enemy.isDead()) {
                    enemy.attack(player);
                    if (player.isDead()) {
                        break; // Si el héroe muere, termina el combate
                    }
                }
            }
        }

        if (player.isDead()) {
            System.out.println("Game Over!");
        } else {
            System.out.println("Nivel completado!");
        }
    }

    public void gameOverMessage() {
        if (player.getScore() > 50) {
            System.out.println("Mortis: ¡Me rendí, no puedo ocultarme más, mañana iré a clase!");
        }
    }

}