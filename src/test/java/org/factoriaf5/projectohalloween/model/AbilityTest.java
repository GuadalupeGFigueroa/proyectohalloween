package org.factoriaf5.projectohalloween.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AbilityTest {
    
    private Ability ability;

    @BeforeEach
    public void setUp() {
        ability = new Ability("Invisibility", "Magic", "Becomes invisible", 3, 2);
    }

    @Test
    public void testInitialCooldownAndDuration() {
        assertEquals(3, ability.getCooldown());
        assertEquals(2, ability.getDuration());
        assertEquals(0, ability.getRemainingCooldown());
        assertEquals(0, ability.getActiveTurnsLeft());
    }

    @Test
    public void testActivateAbility() {
        ability.activate();
        assertEquals(ability.getDuration(), ability.getActiveTurnsLeft());
        assertEquals(ability.getCooldown(), ability.getRemainingCooldown());
    }

    @Test
    public void testActivateAbilityWhenCooldownIsNotZero() {
        ability.setRemainingCooldown(1);
        ability.activate();
        assertNotEquals(ability.getDuration(), ability.getActiveTurnsLeft());
        assertEquals(1, ability.getRemainingCooldown());
    }

    @Test
    public void testDecreaseCooldownAndActiveTurnsLeft() {
        ability.activate(); 

        ability.decreaseCooldown();
        assertEquals(ability.getCooldown() - 1, ability.getRemainingCooldown());
        assertEquals(ability.getDuration() - 1, ability.getActiveTurnsLeft());

        ability.decreaseCooldown();
        ability.decreaseCooldown();
        assertEquals(0, ability.getRemainingCooldown());
        assertEquals(0, ability.getActiveTurnsLeft());
    }

    @Test
    public void testIsAvailable() {
        assertTrue(ability.isAvailable());
        ability.activate();
        assertFalse(ability.isAvailable());

        ability.decreaseCooldown();
        ability.decreaseCooldown();
        ability.decreaseCooldown();
        assertTrue(ability.isAvailable());
    }

    @Test
    public void testIsActive() {
        assertFalse(ability.isActive());

        ability.activate();
        assertTrue(ability.isActive());

        ability.decreaseCooldown();
        ability.decreaseCooldown();
        assertFalse(ability.isActive());
    }
}
