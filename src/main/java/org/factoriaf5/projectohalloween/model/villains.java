package org.factoriaf5.projectohalloween.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "villano_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Villains {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int Life_points;
    private int Attack_points;

    public Villains(){}
    
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

    public abstract void defeated(Aiden jugador);
}