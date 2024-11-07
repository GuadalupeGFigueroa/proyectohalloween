package org.factoriaf5.projectohalloween.controller;

import org.factoriaf5.projectohalloween.service.SkeletonGroupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(SkeletonGroupController.class)
public class SkeletonGroupControllerTest {

    @SuppressWarnings("unused")
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SkeletonGroupService skeletonGroupService;

    @Test
    public void getAllSkeletonGroups_shouldReturnListOfSkeletonGroups() throws Exception {
        // ... (igual al ejemplo anterior)
    }

    @Test
    public void getSkeletonGroupById_shouldReturnSkeletonGroup() throws Exception {
        // ... (igual al ejemplo anterior)
    }
   
    @Test
    public void updateSkeletonGroup_shouldUpdateExistingSkeletonGroup() throws Exception {
        // ... (tu código para probar la actualización de un grupo existente)
    }

    @Test
    public void deleteSkeletonGroup_shouldDeleteExistingSkeletonGroup() throws Exception {
        // ... (tu código para probar la eliminación de un grupo)
    }
}