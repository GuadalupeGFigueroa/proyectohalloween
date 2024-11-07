package org.factoriaf5.projectohalloween.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GhostTest {

    private Ghost ghost;
    private Aiden jugador;

    @BeforeEach
    void setUp() {
        ghost = new Ghost();
        jugador = new Aiden();
        jugador.setScore(0);
    }

    @Test
    void testDefeatedIncreasesPlayerScore() {
        ghost.defeated(jugador);
        
        assertThat("El puntaje del jugador debería ser 15 después de derrotar al Ghost",
                jugador.getScore(), equalTo(15));
    }
}
