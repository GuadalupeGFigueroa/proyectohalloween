package org.factoriaf5.projectohalloween.model;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class StageTest {

    private Stage stage;

    @BeforeEach
    void setUp() {
        stage = new Stage("Haunted Forest", "A spooky forest filled with ghosts", 5);
    }

    @Test
    void testStageAttributes() {
        
        assertThat(stage.getName(), is("Haunted Forest"));
        assertThat(stage.getDescription(), is("A spooky forest filled with ghosts"));
        assertThat(stage.getLevel(), is(5));
    }

    @Test
    void testSettersAndGetters() {
        
        stage.setName("Dark Cave");
        stage.setDescription("A dark, scary cave with unknown creatures");
        stage.setLevel(3);

        assertThat(stage.getName(), equalTo("Dark Cave"));
        assertThat(stage.getDescription(), equalTo("A dark, scary cave with unknown creatures"));
        assertThat(stage.getLevel(), equalTo(3));
    }

    @Test
    void testIdAttribute() {
        
        stage.setId(100);
        assertThat(stage.getId(), is(100L));
    }
}