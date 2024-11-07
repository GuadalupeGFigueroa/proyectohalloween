package org.factoriaf5.projectohalloween.controller;

import java.util.ArrayList;
import java.util.List;

import org.factoriaf5.projectohalloween.model.Aiden;
import org.factoriaf5.projectohalloween.service.AidenService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class AidenControllerTest {

    @Mock
    private AidenService aidenService;

    @InjectMocks
    private AidenController aidenController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllAiden_ReturnsAidenList() {
        List<Aiden> aidens = new ArrayList<>();
        aidens.add(new Aiden());

        when(aidenService.getAllAiden()).thenReturn(aidens);

        List<Aiden> result = aidenController.getAllAiden();
        assertEquals(1, result.size());
        verify(aidenService, times(1)).getAllAiden();
    }

    @Test
    void getAidenById_WhenAidenExists_ReturnsAiden() {
        Aiden aiden = new Aiden();
        when(aidenService.getAidenById(1L)).thenReturn(aiden);

        ResponseEntity<Aiden> response = aidenController.getAidenById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(aiden, response.getBody());
        verify(aidenService, times(1)).getAidenById(1L);
    }

    @Test
    void getAidenById_WhenAidenNotFound_ReturnsNotFound() {
        when(aidenService.getAidenById(1L)).thenThrow(new RuntimeException());

        ResponseEntity<Aiden> response = aidenController.getAidenById(1L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(aidenService, times(1)).getAidenById(1L);
    }

    @Test
    void createAiden_ReturnsCreatedAiden() {
        Aiden aiden = new Aiden();
        when(aidenService.createAiden(aiden)).thenReturn(aiden);

        Aiden result = aidenController.createAiden(aiden);
        assertEquals(aiden, result);
        verify(aidenService, times(1)).createAiden(aiden);
    }

    @Test
    void updateAiden_WhenAidenExists_ReturnsUpdatedAiden() {
        Aiden updatedAiden = new Aiden();
        when(aidenService.updateAiden(1L, updatedAiden)).thenReturn(updatedAiden);

        ResponseEntity<Aiden> response = aidenController.updateAiden(1L, updatedAiden);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedAiden, response.getBody());
        verify(aidenService, times(1)).updateAiden(1L, updatedAiden);
    }

    @Test
    void updateAiden_WhenAidenNotFound_ReturnsNotFound() {
    when(aidenService.updateAiden(eq(1L), any(Aiden.class))).thenThrow(new RuntimeException());

    ResponseEntity<Aiden> response = aidenController.updateAiden(1L, new Aiden());

    assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    verify(aidenService, times(1)).updateAiden(eq(1L), any(Aiden.class));
}


    @Test
    void deleteAiden_WhenAidenExists_ReturnsNoContent() {
        when(aidenService.deleteAiden(1L)).thenReturn(true);

        ResponseEntity<Void> response = aidenController.deleteAiden(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(aidenService, times(1)).deleteAiden(1L);
    }

    @Test
    void deleteAiden_WhenAidenNotFound_ReturnsNotFound() {
        when(aidenService.deleteAiden(1L)).thenReturn(false);

        ResponseEntity<Void> response = aidenController.deleteAiden(1L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(aidenService, times(1)).deleteAiden(1L);
    }
}