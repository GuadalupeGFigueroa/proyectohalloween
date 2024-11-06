package org.factoriaf5.projectohalloween.model;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BackpackTest {

    @Test
    public void testAddItemToBackpack() {
        Backpack backpack = new Backpack();
        Object item = new Object("Enchanted Sword", "Weapon", "Increases attack power");
        boolean result = backpack.addItem(item);

        assertThat(result, is(true));
        assertThat(backpack.getItems(), hasItem(item));
    }

    @Test
    public void testRemoveItemFromBackpack() {
        Backpack backpack = new Backpack();
        Object item = new Object("Health Potion", "Healing", "Restores health points");
        backpack.addItem(item);
        boolean result = backpack.removeItem(item);

        assertThat(result, is(true));
        assertThat(backpack.getItems(), not(hasItem(item)));
    }

    @Test
    public void testAddItemWhenBackpackIsFull() {
        Backpack backpack = new Backpack();
        Object item1 = new Object("Enchanted Sword", "Weapon", "Increases attack power");
        Object item2 = new Object("Health Potion", "Healing", "Restores health points");
        Object item3 = new Object("Magic Shield", "Defense", "Blocks incoming attacks");
        Object item4 = new Object("Fireball Scroll", "Magic", "Burns the enemy");

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
