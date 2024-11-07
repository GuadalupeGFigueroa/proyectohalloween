package org.factoriaf5.projectohalloween.model;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class ObjectTest {

    @Test
    public void testObjectProperties() {

        GameObject obj = new GameObject("Enchanted Sword", "Weapon", "Increases attack power");

        assertThat(obj.getName(), is("Enchanted Sword"));
        assertThat(obj.getType(), is("Weapon"));
        assertThat(obj.getEffect(), is("Increases attack power"));
    }

    @Test
    public void testGetters() {
        GameObject obj = new GameObject("Healt Potion", "Healing", "Restores health points");

        assertThat(obj.getName(), is("Healt Potion"));
        assertThat(obj.getType(), is("Healing"));
        assertThat(obj.getEffect(), is("Restores health points"));
    }

    @Test
    public void testSetters() {
        GameObject obj = new GameObject("Magic Amulet", "Buff", "Increases magic power");

        obj.setName("Magic Amulet");
        obj.setType("Buff");
        obj.setEffect("Increases magic power");
    }
}