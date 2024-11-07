package org.factoriaf5.projectohalloween.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.factoriaf5.projectohalloween.model.Backpack;
import org.factoriaf5.projectohalloween.model.Aiden; 
import org.factoriaf5.projectohalloween.repository.BackpackRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.*;

public class BackpackServiceTest {

    @Mock
    private BackpackRepository backpackRepository;

    @InjectMocks
    private BackpackService backpackService;

    private Backpack backpack;
    private Aiden aiden; 

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    
        
        aiden = new Aiden(); 
        backpack = new Backpack(aiden); 
    
       
    }
    

    @Test
    void createBackpack_ShouldSaveAndReturnBackpack() {
        
        when(backpackRepository.save(backpack)).thenReturn(backpack);

   
        Backpack result = backpackService.createBackpack(backpack);

        
        assertThat(result, is(notNullValue()));

    

       
        assertThat(result.getAiden(), is(notNullValue()));

        
        assertThat(result.getItems(), is(empty()));

        
        verify(backpackRepository, times(1)).save(backpack);
    }

    @Test
    void findBackpackById_ShouldReturnBackpack_WhenFound() {
      
        when(backpackRepository.findById(1L)).thenReturn(Optional.of(backpack));

       
        Optional<Backpack> result = backpackService.findBackpackById(1L);

     
        assertThat(result.isPresent(), is(true));
        assertThat(result.get(), is(equalTo(backpack)));

     
        verify(backpackRepository, times(1)).findById(1L);
    }

    @Test
    void findBackpackById_ShouldReturnEmpty_WhenNotFound() {
        
        when(backpackRepository.findById(1L)).thenReturn(Optional.empty());

       
        Optional<Backpack> result = backpackService.findBackpackById(1L);

      
        assertThat(result.isPresent(), is(false));

     
        verify(backpackRepository, times(1)).findById(1L);
    }

    @Test
    void saveBackpack_ShouldSaveAndReturnBackpack() {
    
        when(backpackRepository.save(backpack)).thenReturn(backpack);

        
        Backpack result = backpackService.save(backpack);

        
        assertThat(result, is(notNullValue()));


        
        verify(backpackRepository, times(1)).save(backpack);
    }

    @Test
    void deleteBackpack_ShouldDeleteBackpack() {
       
        doNothing().when(backpackRepository).deleteById(1L);

        
        backpackService.deleteBackpack(1L);

        
        verify(backpackRepository, times(1)).deleteById(1L);
    }
}
