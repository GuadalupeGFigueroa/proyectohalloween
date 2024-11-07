package org.factoriaf5.projectohalloween.model;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

public class BackpackTest {

    @Test
    public void testAddItemToBackpack() {
        Backpack backpack = new Backpack();
        GameObject item = new GameObject("Enchanted Sword", "Weapon", "Increases attack power");
        boolean result = backpack.addItem(item);

        assertThat(result, is(true));
        assertThat(backpack.getItems(), hasItem(item));
    }

    @Test
    public void testRemoveItemFromBackpack() {
        Backpack backpack = new Backpack();
        GameObject item = new GameObject("Health Potion", "Healing", "Restores health points");
        backpack.addItem(item);
        boolean result = backpack.removeItem(item);

        assertThat(result, is(true));
        assertThat(backpack.getItems(), not(hasItem(item)));
    }

    @Test
    public void testAddItemWhenBackpackIsFull() {
        Backpack backpack = new Backpack();
        GameObject item1 = new GameObject("Enchanted Sword", "Weapon", "Increases attack power");
        GameObject item2 = new GameObject("Health Potion", "Healing", "Restores health points");
        GameObject item3 = new GameObject("Magic Shield", "Defense", "Blocks incoming attacks");
        GameObject item4 = new GameObject("Fireball Scroll", "Magic", "Burns the enemy");

        backpack.addItem(item1);
        backpack.addItem(item2);
        backpack.addItem(item3);

        boolean result = backpack.addItem(item4);

        assertThat(result, is(false));
        assertThat(backpack.getItems(), not(hasItem(item4)));
    }

    @Test
    public void testBackpackInitialization() {
        Aiden aiden = new Aiden(); // Asume que tienes una clase Aiden con un constructor vacío
        Backpack backpack = new Backpack(aiden);

        assertThat(backpack.getAiden(), is(aiden));
        assertThat(backpack.getItems(), is(empty()));
    }
}
