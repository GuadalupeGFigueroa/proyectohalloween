package org.factoriaf5.projectohalloween.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.factoriaf5.projectohalloween.model.Aiden;
import org.factoriaf5.projectohalloween.model.Villains;
import org.factoriaf5.projectohalloween.service.VillainsService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

@ExtendWith(MockitoExtension.class)
class VillainsControllerTest {

    @InjectMocks
    private VillainsController villainsController;

    @Mock
    private VillainsService villainsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllVillains() {
        // Arrange
        Villains villain1 = new VillainStub(10, 5); // Utiliza un stub o una clase concreta que extienda Villains
        Villains villain2 = new VillainStub(20, 10);
        List<Villains> expectedVillains = Arrays.asList(villain1, villain2);

        when(villainsService.getAllVillains()).thenReturn(expectedVillains);

        // Act
        List<Villains> actualVillains = villainsController.getAllVillains();

        // Assert
        assertEquals(expectedVillains, actualVillains);
        verify(villainsService, times(1)).getAllVillains();
    }

    @Test
    void testGetVillainByIdFound() {
        // Arrange
        Long villainId = 1L;
        Villains expectedVillain = new VillainStub(10, 5);
        when(villainsService.getVillainById(villainId)).thenReturn(Optional.of(expectedVillain));

        // Act
        ResponseEntity<Villains> response = villainsController.getVillainById(villainId);

        // Assert
        assertEquals(ResponseEntity.ok(expectedVillain), response);
        verify(villainsService, times(1)).getVillainById(villainId);
    }

    @Test
    void testGetVillainByIdNotFound() {
        // Arrange
        Long villainId = 1L;
        when(villainsService.getVillainById(villainId)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Villains> response = villainsController.getVillainById(villainId);

        // Assert
        assertEquals(ResponseEntity.notFound().build(), response);
        verify(villainsService, times(1)).getVillainById(villainId);
    }

    @Test
    void testCreateVillain() {
        // Arrange
        Villains villainToCreate = new VillainStub(10, 5);
        when(villainsService.createVillain(any(Villains.class))).thenReturn(villainToCreate);

        // Act
        Villains createdVillain = villainsController.createVillain(villainToCreate);

        // Assert
        assertEquals(villainToCreate, createdVillain);
        verify(villainsService, times(1)).createVillain(villainToCreate);
    }

    @Test
    void testUpdateVillainFound() {
        // Arrange
        Long villainId = 1L;
        Villains villainDetails = new VillainStub(15, 7);
        Villains updatedVillain = new VillainStub(15, 7);
        when(villainsService.updateVillain(villainId, villainDetails)).thenReturn(Optional.of(updatedVillain));

        // Act
        ResponseEntity<Villains> response = villainsController.updateVillain(villainId, villainDetails);

        // Assert
        assertEquals(ResponseEntity.ok(updatedVillain), response);
        verify(villainsService, times(1)).updateVillain(villainId, villainDetails);
    }

    @Test
    void testUpdateVillainNotFound() {
        // Arrange
        Long villainId = 1L;
        Villains villainDetails = new VillainStub(15, 7);
        when(villainsService.updateVillain(villainId, villainDetails)).thenReturn(Optional.empty());

        // Act
        ResponseEntity<Villains> response = villainsController.updateVillain(villainId, villainDetails);

        // Assert
        assertEquals(ResponseEntity.notFound().build(), response);
        verify(villainsService, times(1)).updateVillain(villainId, villainDetails);
    }

    @Test
    void testDeleteVillainSuccess() {
        // Arrange
        Long villainId = 1L;
        when(villainsService.deleteVillain(villainId)).thenReturn(true);

        // Act
        ResponseEntity<Void> response = villainsController.deleteVillain(villainId);

        // Assert
        assertEquals(ResponseEntity.noContent().build(), response);
        verify(villainsService, times(1)).deleteVillain(villainId);
    }

    @Test
    void testDeleteVillainNotFound() {
        // Arrange
        Long villainId = 1L;
        when(villainsService.deleteVillain(villainId)).thenReturn(false);

        // Act
        ResponseEntity<Void> response = villainsController.deleteVillain(villainId);

        // Assert
        assertEquals(ResponseEntity.notFound().build(), response);
        verify(villainsService, times(1)).deleteVillain(villainId);
    }

    // Stub class for testing, replace with your actual subclass of Villains
    static class VillainStub extends Villains {
        public VillainStub(int life_points, int attack_points) {
            super(life_points, attack_points);
        }

        @Override
        public void defeated(Aiden jugador) {
            // Implementación de prueba, si es necesario
        }
    }
}