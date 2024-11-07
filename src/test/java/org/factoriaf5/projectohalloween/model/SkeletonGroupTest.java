package org.factoriaf5.projectohalloween.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class SkeletonGroupTest {

    private SkeletonGroup skeletonGroup;
    private Aiden player;

    @BeforeEach
    void setUp() {
        skeletonGroup = new SkeletonGroup(5);  
        player = new Aiden("Jugador", 100, 10, 0); 
    }

    @Test
    void constructorShouldInitializeSkeletonsCorrectly() {
        assertThat(skeletonGroup.getSkeletons(), hasSize(5));
        assertThat(skeletonGroup.getLife_points(), is(50));  
        assertThat(skeletonGroup.getAttack_points(), is(25));  
    }

    @Test
    void groupAttackShouldReducePlayerLifePoints() {
        skeletonGroup.groupAttack(player);
        int expectedLifePoints = 100 - (5 * skeletonGroup.getAttack_points() / 5);
        assertThat(player.getLife_points(), is(equalTo(expectedLifePoints)));
    }

    @Test
    void removeDefeatedSkeletonShouldReduceGroupSizeAndLifePoints() {
        skeletonGroup.removeDefeatedSkeleton();
        assertThat(skeletonGroup.getSkeletons(), hasSize(4));  
        assertThat(skeletonGroup.getLife_points(), is(40));  
    }

    @Test
    void removeDefeatedSkeletonShouldSetLifePointsToZeroWhenEmpty() {
        for (int i = 0; i < 5; i++) {
            skeletonGroup.removeDefeatedSkeleton();
        }
        assertThat(skeletonGroup.getSkeletons(), is(empty()));
        assertThat(skeletonGroup.getLife_points(), is(0));
    }

    @Test
    void removeDefeatedSkeletonShouldNotRemoveWhenEmpty() {
        for (int i = 0; i < 5; i++) {
            skeletonGroup.removeDefeatedSkeleton();
        }
        skeletonGroup.removeDefeatedSkeleton();  
        assertThat(skeletonGroup.getSkeletons(), is(empty())); 
    }

    @Test
    void defeatedShouldIncreasePlayerScore() {
        skeletonGroup.defeated(player);
        int expectedScore = 10 * skeletonGroup.getSkeletons().size();
        assertThat(player.getScore(), is(expectedScore));
    }

    @Test
void applyAbilityEffectsShouldAffectGroupAttack() {
    Ability shield = new Ability("Escudo Protector", "Defensa", "Protección", 0, 2); 
    player.addAbility(shield);
    player.applyAbilityEffects();

    int initialLifePoints = player.getLife_points();
    skeletonGroup.groupAttack(player);

    assertThat(player.getLife_points(), is(lessThan(initialLifePoints))); 
}


    @Test
    void defeatedShouldNotChangeScoreWhenNoSkeletons() {
        for (int i = 0; i < 5; i++) {
            skeletonGroup.removeDefeatedSkeleton();
        }
        int initialScore = player.getScore();
        skeletonGroup.defeated(player);
        assertThat(player.getScore(), is(initialScore)); 
    }
}
