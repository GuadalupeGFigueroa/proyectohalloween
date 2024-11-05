package org.factoriaf5.projectohalloween.model;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import java.lang.reflect.Field;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AidenTest {
    private Aiden aiden; 

    @BeforeEach
    void setUp(){
        aiden = new Aiden(1L, "Aiden", 100, 50, 0, 0, 300);
    }

    @Test
    void testAidenHas5Attributes(){
        Field[] aidenFields = aiden.getClass().getDeclaredFields();
        assertThat(aidenFields.length, is(5));
    }

    @Test
    void testAidenGetters(){
        assertThat(aiden.getId(), is(1L));
        assertThat(aiden.getName(), is("Aiden"));
        assertThat(aiden.getLife_points(), is (100));
        assertThat(aiden.getAttack_power(), is (50));
        assertThat(aiden.getScore(), is (300));
    }

}