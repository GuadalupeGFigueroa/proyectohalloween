package org.factoriaf5.projectohalloween.service;

import org.factoriaf5.projectohalloween.model.Aiden;
import org.factoriaf5.projectohalloween.model.Backpack;
import org.factoriaf5.projectohalloween.repository.AidenRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AidenServiceTest {

    @Mock
    private AidenRepository aidenRepository;

    @InjectMocks
    private AidenService aidenService;

    private Aiden aiden;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        aiden = new Aiden();
        aiden.setId(1L);
        aiden.setName("Aiden");
        aiden.setLife_points(100);
        aiden.setAttack_points(50);
        aiden.setScore(0);
    }

    @Test
    void testGetAllAiden() {
        
        when(aidenRepository.findAll()).thenReturn(List.of(aiden));

        
        var result = aidenService.getAllAiden();

        
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Aiden", result.get(0).getName());
        verify(aidenRepository, times(1)).findAll();
    }

    @Test
    void testGetAidenById_Success() {
        
        when(aidenRepository.findById(1L)).thenReturn(Optional.of(aiden));

        
        Aiden result = aidenService.getAidenById(1L);

        
        assertNotNull(result);
        assertEquals("Aiden", result.getName());
        verify(aidenRepository, times(1)).findById(1L);
    }

    @Test
    void testGetAidenById_NotFound() {
        
        when(aidenRepository.findById(1L)).thenReturn(Optional.empty());

        
        RuntimeException exception = assertThrows(RuntimeException.class, () -> aidenService.getAidenById(1L));
        assertEquals("Aiden's not found with id: 1", exception.getMessage());
        verify(aidenRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateAiden() {
        
        when(aidenRepository.save(any(Aiden.class))).thenReturn(aiden);

        
        Aiden result = aidenService.createAiden(aiden);

    
        assertNotNull(result);
        assertEquals("Aiden", result.getName());
        verify(aidenRepository, times(1)).save(any(Aiden.class));
    }

    @Test
    void testUpdateAiden_Success() {
        
        Aiden updatedAiden = new Aiden();
        updatedAiden.setName("Updated Aiden");
        updatedAiden.setLife_points(90);
        updatedAiden.setAttack_points(60);
        updatedAiden.setScore(10);

        when(aidenRepository.findById(1L)).thenReturn(Optional.of(aiden));
        when(aidenRepository.save(any(Aiden.class))).thenReturn(updatedAiden);

        
        Aiden result = aidenService.updateAiden(1L, updatedAiden);

        
        assertNotNull(result);
        assertEquals("Updated Aiden", result.getName());
        assertEquals(90, result.getLife_points());
        assertEquals(60, result.getAttack_points());
        assertEquals(10, result.getScore());
        verify(aidenRepository, times(1)).findById(1L);
        verify(aidenRepository, times(1)).save(any(Aiden.class));
    }

    @Test
    void testDeleteAiden_Success() {
        
        when(aidenRepository.findById(1L)).thenReturn(Optional.of(aiden));

        
        boolean result = aidenService.deleteAiden(1L);

        
        assertTrue(result);
        verify(aidenRepository, times(1)).findById(1L);
        verify(aidenRepository, times(1)).delete(any(Aiden.class));
    }

    @Test
    void testDeleteAiden_NotFound() {
        
        when(aidenRepository.findById(1L)).thenReturn(Optional.empty());

        
        RuntimeException exception = assertThrows(RuntimeException.class, () -> aidenService.deleteAiden(1L));
        assertEquals("Aiden's not found with id: 1", exception.getMessage());
        verify(aidenRepository, times(1)).findById(1L);
    }
}