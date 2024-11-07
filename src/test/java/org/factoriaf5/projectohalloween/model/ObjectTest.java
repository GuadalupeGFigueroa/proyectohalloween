package org.factoriaf5.projectohalloween.model;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ObjectTest {

    @Test
    public void testObjectProperties() {
        
        Object obj = new Object("Enchanted Sword", "Weapon", "Increases attack power");

        assertThat(obj.getName(), is("Enchanted Sword"));
        assertThat(obj.getType(), is("Weapon"));
        assertThat(obj.getEffect(), is("Increases attack power"));
    }

    @Test
    public void testGetters() {
        Object obj = new Object("Healt Potion", "Healing", "Restores health points");

        assertThat(obj.getName(), is("Healt Potion"));
        assertThat(obj.getType(), is("Healing"));
        assertThat(obj.getEffect(), is("Restores health points"));
    }

    @Test
    public void testSetters() {
        Object obj = new Object("Magic Amulet", "Buff", "Increases magic power");


        obj.setName("Magic Amulet");
        obj.setType("Buff");
        obj.setEffect("Increases magic power");
    }
}