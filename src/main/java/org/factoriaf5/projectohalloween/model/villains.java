package org.factoriaf5.projectohalloween.model;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "villano_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Villains {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int Life_points;
    private int Attack_points;

    public Villains() {
    }

    public Villains(int Life_points, int Attack_points) {
        this.Life_points = Life_points;
        this.Attack_points = Attack_points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLife_points() {
        return Life_points;
    }

    public void setLife_points(int Life_points) {
        this.Life_points = Life_points;
    }

    public int getAttack_points() {
        return Attack_points;
    }

    public void setAttack_points(int Attack_points) {
        this.Attack_points = Attack_points;
    }

    public boolean isDead() {
        return this.Life_points <= 0;
    }

    public void attack(Aiden player) {
        player.setLife_points(player.getLife_points() - this.Attack_points);
    }

    public abstract void defeated(Aiden player);
}