package org.factoriaf5.projectohalloween.model;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AidenTest {
    private Aiden aiden;

    @BeforeEach
    void setUp() {
        aiden = new Aiden("Aiden", 100, 50, 300);
    }

    @Test
    void testAidenHas5Attributes() {
        Field[] aidenFields = aiden.getClass().getDeclaredFields();
        assertThat(aidenFields.length, is(5));
    }

    @Test
    void testAidenGetters() {
        assertThat(aiden.getName(), is("Aiden"));
        assertThat(aiden.getLife_points(), is(100));
        assertThat(aiden.getAttack_points(), is(50));
        assertThat(aiden.getScore(), is(300));
    }

}