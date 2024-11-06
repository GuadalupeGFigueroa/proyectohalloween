package org.factoriaf5.projectohalloween.model;

import jakarta.persistence.Entity;

@Entity
public class Ghost extends Villains {
    public Ghost() {
        super(15, 7);
    }

    @Override
    public void defeated(Aiden Player) {
        Player.setScore(Player.getScore() + 15);
    }
}
