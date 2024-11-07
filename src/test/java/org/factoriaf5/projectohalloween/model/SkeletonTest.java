package org.factoriaf5.projectohalloween.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SkeletonTest {

    private Skeleton skeleton;
    private Aiden jugador;

    @BeforeEach
    void setUp() {
        skeleton = new Skeleton();
        jugador = new Aiden();
        jugador.setScore(0);
    }

    @Test
    void testDefeatedIncreasesPlayerScore() {
        skeleton.defeated(jugador);
        
        assertThat("El puntaje del jugador debería ser 10 después de derrotar al Skeleton",
                jugador.getScore(), equalTo(10));
    }
}
