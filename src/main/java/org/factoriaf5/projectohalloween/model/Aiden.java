package org.factoriaf5.projectohalloween.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Aiden")

public class Aiden {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_aiden")
    private Long id;
    private String name;
    private int life_points;
    private int attack_power;
    private int level;
    private int experience;
    private int score;

    
    public Aiden() {
    }

    public Aiden(Long id, String name, int life_points, int attack_power, int level, int experience, int score) {
        this.id = id;
        this.name = name;
        this.life_points = life_points;
        this.attack_power = attack_power;
        this.level = level;
        this.experience = experience;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife_points() {
        return life_points;
    }

    public void setLife_points(int life_points) {
        this.life_points = life_points;
    }

    public int getAttack_power() {
        return attack_power;
    }

    public void setAttack_power(int attack_power) {
        this.attack_power = attack_power;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
