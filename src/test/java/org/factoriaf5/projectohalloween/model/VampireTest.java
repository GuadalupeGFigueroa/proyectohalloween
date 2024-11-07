package org.factoriaf5.projectohalloween.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VampireTest {

    private Vampire vampire;
    private Aiden jugador;

    @BeforeEach
    void setUp() {
        vampire = new Vampire();
        jugador = new Aiden();
        jugador.setScore(0);
        jugador.setLife_points(100);
    }

    @Test
    void testDefeatedIncreasesPlayerScoreAndLifePoints() {
        vampire.defeated(jugador);

        assertThat("El puntaje del jugador debería ser 20 después de derrotar al Vampire",
                jugador.getScore(), equalTo(20));

        int expectedLifePoints = 100 + (100 / 2);
        assertThat("Los puntos de vida del jugador deberían aumentar en un 50% después de derrotar al Vampire",
                jugador.getLife_points(), equalTo(expectedLifePoints));
    }
}
