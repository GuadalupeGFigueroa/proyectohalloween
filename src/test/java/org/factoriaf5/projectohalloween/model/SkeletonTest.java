package org.factoriaf5.projectohalloween.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class SkeletonTest {

    private Skeleton skeleton;
    private Aiden jugador;

    @BeforeEach
    void setUp() {
        skeleton = new Skeleton();    // Inicializamos un Skeleton
        jugador = new Aiden();        // Inicializamos un jugador (Aiden)
        jugador.setScore(0);          // Seteamos el puntaje inicial del jugador a 0
    }

    @Test
    void testDefeatedIncreasesPlayerScore() {
        skeleton.defeated(jugador);   // Ejecutamos el método defeated en el Skeleton
        
        // Verificamos que el puntaje del jugador ahora sea 10
        assertThat("El puntaje del jugador debería ser 10 después de derrotar al Skeleton",
                jugador.getScore(), equalTo(10));
    }
}
