package org.factoriaf5.projectohalloween.model;

import jakarta.persistence.Entity;

@Entity
public class Skeleton extends Villains {
    public Skeleton() {
        super(10, 5);
    }

    @Override
    public void defeated(Aiden jugador) {
        jugador.setScore(jugador.getScore() + 10);
    }
}