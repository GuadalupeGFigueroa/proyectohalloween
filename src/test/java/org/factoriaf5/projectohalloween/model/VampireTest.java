package org.factoriaf5.projectohalloween.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.closeTo;

class VampireTest {

    private Vampire vampire;
    private Aiden jugador;

    @BeforeEach
    void setUp() {
        vampire = new Vampire();      // Inicializamos un Vampire
        jugador = new Aiden();        // Inicializamos un jugador (Aiden)
        jugador.setScore(0);          // Puntaje inicial en 0
        jugador.setLife_points(100);  // Vida inicial en 100
    }

    @Test
    void testDefeatedIncreasesPlayerScoreAndLifePoints() {
        vampire.defeated(jugador);    // Ejecutamos el método defeated en el Vampire
        
        // Verificamos que el puntaje del jugador aumente a 20
        assertThat("El puntaje del jugador debería ser 20 después de derrotar al Vampire",
                jugador.getScore(), equalTo(20));

        // Verificamos que la vida del jugador aumente en un 50%
        int expectedLifePoints = 100 + (100 / 2);  // 100 + 50 = 150
        assertThat("Los puntos de vida del jugador deberían aumentar en un 50% después de derrotar al Vampire",
                jugador.getLife_points(), equalTo(expectedLifePoints));
    }
}
