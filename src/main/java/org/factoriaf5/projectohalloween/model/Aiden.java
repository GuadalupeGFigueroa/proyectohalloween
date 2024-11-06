package org.factoriaf5.projectohalloween.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Aiden")
public class Aiden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int life_points;
    private int Attack_points;
    private int score;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "aiden_id")
    private List<Ability> abilities = new ArrayList<>();

    public Aiden() {
    }

    public Aiden(String name, int life_points, int Attack_points, int score) {
        this.name = name;
        this.life_points = life_points;
        this.Attack_points = Attack_points;
        this.score = score;
    }

    public void addAbility(Ability ability) {
        abilities.add(ability);
    }

    public boolean isDead() {
        return this.life_points <= 0;
    }

    public void attack(Villains enemy) {
        enemy.setLife_points(enemy.getLife_points() - this.Attack_points);
    }

    public void applyAbilityEffects() {
        for (Ability ability : abilities) {
            ability.decreaseCooldown();
            if (ability.isActive()) {
                switch (ability.getName()) {
                    case "Golpe Potente":
                        this.Attack_points += 10;
                        break;
                    case "Escudo Protector":
                        this.life_points += 5; // O restar 5 al daño recibido
                        break;
                }
            }
        }
    }

    public boolean useAbility(String abilityName) {
        for (Ability ability : abilities) {
            if (ability.getName().equals(abilityName) && ability.isAvailable()) {
                ability.activate();
                return true;
            }
        }
        return false;
    }

    public int getLife_points() {
        return life_points;
    }

    public int getAttack_points() {
        return Attack_points;
    }

    public List<Ability> getAbilities() {
        return abilities;
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

    public void setLife_points(int life_points) {
        this.life_points = life_points;
    }

    public void setAttack_points(int Attack_points) {
        this.Attack_points = Attack_points;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public void addItem(Health_Potion health_Potion) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addItem'");
    }
}
