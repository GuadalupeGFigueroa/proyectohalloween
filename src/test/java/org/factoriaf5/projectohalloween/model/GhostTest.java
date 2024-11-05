package org.factoriaf5.projectohalloween.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class GhostTest {

    private Ghost ghost;
    private Aiden jugador;

    @BeforeEach
    void setUp() {
        ghost = new Ghost();         // Inicializamos un Ghost
        jugador = new Aiden();       // Inicializamos un jugador (Aiden)
        jugador.setScore(0);         // Seteamos el puntaje inicial del jugador a 0
    }

    @Test
    void testDefeatedIncreasesPlayerScore() {
        ghost.defeated(jugador);     // Ejecutamos el método defeated en el Ghost
        
        // Verificamos que el puntaje del jugador ahora sea 15
        assertThat("El puntaje del jugador debería ser 15 después de derrotar al Ghost",
                jugador.getScore(), equalTo(15));
    }
}
