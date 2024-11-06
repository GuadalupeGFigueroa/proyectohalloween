package org.factoriaf5.projectohalloween.controller;

import org.factoriaf5.projectohalloween.model.Aiden;
import org.factoriaf5.projectohalloween.model.Villains;
import org.factoriaf5.projectohalloween.service.VillainsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class VillainsControllerTest {

    @Mock
    private VillainsService villainsService;

    @InjectMocks
    private VillainsController villainsController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllVillains() {
        Villains villain1 = new Villains(100, 10) {
            @Override
            public void defeated(Aiden jugador) {
                // Implementa el método aquí
            }
        };
        Villains villain2 = new Villains(200, 20) {
            @Override
            public void defeated(Aiden jugador) {
                // Implementa el método aquí
            }
        };
        List<Villains> villainsList = Arrays.asList(villain1, villain2);

        when(villainsService.getAllVillains()).thenReturn(villainsList);

        List<Villains> result = villainsController.getAllVillains();

        assertThat(result, hasSize(2));
        assertThat(result, contains(villain1, villain2));
    }

    @Test
    public void testGetVillainById() {
        Villains villain = new Villains(100, 10) {
            @Override
            public void defeated(Aiden jugador) {
                // Implementa el método aquí
            }
        };
        when(villainsService.getVillainById(1L)).thenReturn(Optional.of(villain));

        ResponseEntity<Villains> response = villainsController.getVillainById(1L);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(villain));
    }

    @Test
    public void testCreateVillain() {
        Villains villain = new Villains(100, 10) {
            @Override
            public void defeated(Aiden jugador) {
                // Implementa el método aquí
            }
        };
        when(villainsService.createVillain(any(Villains.class))).thenReturn(villain);

        Villains result = villainsController.createVillain(villain);

        assertThat(result, is(villain));
    }

    @Test
    public void testUpdateVillain() {
        Villains villain = new Villains(100, 10) {
            @Override
            public void defeated(Aiden jugador) {
                // Implementa el método aquí
            }
        };
        when(villainsService.updateVillain(eq(1L), any(Villains.class))).thenReturn(Optional.of(villain));

        ResponseEntity<Villains> response = villainsController.updateVillain(1L, villain);

        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(villain));
    }

    @Test
    public void testDeleteVillain() {
        when(villainsService.deleteVillain(1L)).thenReturn(true);

        ResponseEntity<Void> response = villainsController.deleteVillain(1L);

        assertThat(response.getStatusCode(), is(HttpStatus.NO_CONTENT));
    }
}
