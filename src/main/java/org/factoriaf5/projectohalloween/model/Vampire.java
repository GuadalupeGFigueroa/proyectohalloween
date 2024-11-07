package org.factoriaf5.projectohalloween.model;

import jakarta.persistence.Entity;

@Entity
public class Vampire extends Villains {
    public Vampire() {
        super(20, 10);

    @Override
    public void defeated(Aiden jugador) {
        jugador.setScore(jugador.getScore() + 20);
        jugador.setLife_points(jugador.getLife_points() + jugador.getLife_points() / 2);
    }
}
