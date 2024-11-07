package org.factoriaf5.projectohalloween.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.factoriaf5.projectohalloween.model.SkeletonGroup;
import org.factoriaf5.projectohalloween.repository.SkeletonGroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SkeletonGroupServiceTest {

    @Mock
    private SkeletonGroupRepository repository;

    @InjectMocks
    private SkeletonGroupService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllSkeletonGroups() {
        SkeletonGroup skeletonGroup = new SkeletonGroup(5);
        when(repository.findAll()).thenReturn(List.of(skeletonGroup));

        List<SkeletonGroup> result = service.getAllSkeletonGroups();

        assertThat(result, hasSize(1));
        assertThat(result.get(0).getSkeletons(), hasSize(5));
    }

    @Test
    public void testGetSkeletonGroupById() {
        SkeletonGroup skeletonGroup = new SkeletonGroup(3);
        when(repository.findById(1L)).thenReturn(Optional.of(skeletonGroup));

        Optional<SkeletonGroup> result = service.getSkeletonGroupById(1L);

        assertThat(result.isPresent(), is(true));
        assertThat(result.get().getSkeletons(), hasSize(3));
    }

    @Test
    public void testCreateSkeletonGroup() {
        SkeletonGroup skeletonGroup = new SkeletonGroup(2);
        when(repository.save(skeletonGroup)).thenReturn(skeletonGroup);

        SkeletonGroup result = service.createSkeletonGroup(skeletonGroup);

        assertThat(result.getSkeletons(), hasSize(2));
        assertThat(result.getLife_points(), is(20));
        assertThat(result.getAttack_points(), is(10));
    }

    @Test
    public void testUpdateSkeletonGroup() {
        SkeletonGroup existingGroup = new SkeletonGroup(4);
        SkeletonGroup updatedGroup = new SkeletonGroup(6);
        when(repository.findById(1L)).thenReturn(Optional.of(existingGroup));
        when(repository.save(existingGroup)).thenReturn(updatedGroup);

        Optional<SkeletonGroup> result = service.updateSkeletonGroup(1L, updatedGroup);

        assertThat(result.isPresent(), is(true));
        assertThat(result.get().getSkeletons(), hasSize(6));
    }

    @Test
    public void testDeleteSkeletonGroup() {
        when(repository.existsById(1L)).thenReturn(true);

        boolean result = service.deleteSkeletonGroup(1L);

        assertThat(result, is(true));
        verify(repository, times(1)).deleteById(1L);
    }
}
