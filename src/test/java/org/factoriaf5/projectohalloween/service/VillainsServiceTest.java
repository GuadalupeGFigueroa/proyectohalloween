package org.factoriaf5.projectohalloween.service;

import org.factoriaf5.projectohalloween.model.Aiden;
import org.factoriaf5.projectohalloween.model.Villains;
import org.factoriaf5.projectohalloween.repository.VillainsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class VillainsServiceTest {

    @Mock
    private VillainsRepository villainsRepository;

    @InjectMocks
    private VillainsService villainsService;

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

        when(villainsRepository.findAll()).thenReturn(villainsList);

        List<Villains> result = villainsService.getAllVillains();

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
        when(villainsRepository.findById(1L)).thenReturn(Optional.of(villain));

        Optional<Villains> result = villainsService.getVillainById(1L);

        assertThat(result.isPresent(), is(true));
        assertThat(result.get(), is(villain));
    }

    @Test
    public void testCreateVillain() {
        Villains villain = new Villains(100, 10) {
            @Override
            public void defeated(Aiden jugador) {
                // Implementa el método aquí
            }
        };
        when(villainsRepository.save(any(Villains.class))).thenReturn(villain);

        Villains result = villainsService.createVillain(villain);

        assertThat(result, is(villain));
    }

    @Test
    public void testUpdateVillain() {
        Villains existingVillain = new Villains(100, 10) {
            @Override
            public void defeated(Aiden jugador) {
                // Implementa el método aquí
            }
        };
        Villains updatedDetails = new Villains(150, 15) {
            @Override
            public void defeated(Aiden jugador) {
                // Implementa el método aquí
            }
        };
        when(villainsRepository.findById(1L)).thenReturn(Optional.of(existingVillain));
        when(villainsRepository.save(any(Villains.class))).thenReturn(updatedDetails);

        Optional<Villains> result = villainsService.updateVillain(1L, updatedDetails);

        assertThat(result.isPresent(), is(true));
        assertThat(result.get().getLife_points(), is(150));
        assertThat(result.get().getAttack_points(), is(15));
    }

    @Test
    public void testDeleteVillain() {
        Villains villain = new Villains(100, 10) {
            @Override
            public void defeated(Aiden jugador) {
                // Implementa el método aquí
            }
        };
        when(villainsRepository.findById(1L)).thenReturn(Optional.of(villain));
        doNothing().when(villainsRepository).delete(villain);

        boolean result = villainsService.deleteVillain(1L);

        assertThat(result, is(true));
        verify(villainsRepository, times(1)).delete(villain);
    }
}
