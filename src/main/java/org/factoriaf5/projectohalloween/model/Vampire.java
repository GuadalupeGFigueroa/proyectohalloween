package org.factoriaf5.projectohalloween.model;

import jakarta.persistence.Entity;

@Entity
public class Vampire extends Villains {
    public Vampire() {
        super(20, 10);  // Vida: 20, Ataque: 10
    }

    @Override
    public void derrotado(Aiden jugador) {
        jugador.setPuntuacion(jugador.getPuntuacion() + 20);
        jugador.setPuntosVida(jugador.getPuntosVida() + jugador.getPuntosVida() / 2);  // Recupera el 50% de vida
    }
}
