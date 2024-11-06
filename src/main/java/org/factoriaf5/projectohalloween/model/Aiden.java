package org.factoriaf5.projectohalloween.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Aiden")
public class Aiden {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int lifePoints;
    private int attackPower;
    private int score;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "aiden_id")
    private List<Ability> abilities = new ArrayList<>();

    public Aiden() {}

    public Aiden(String name, int lifePoints, int attackPower, int score) {
        this.name = name;
        this.lifePoints = lifePoints;
        this.attackPower = attackPower;
        this.score = score;
    }

    public void addAbility(Ability ability) {
        abilities.add(ability);
    }

    public void applyAbilityEffects() {
        for (Ability ability : abilities) {
            ability.decreaseCooldown();
            if (ability.isActive()) {
                switch (ability.getName()) {
                    case "Golpe Potente":
                        this.attackPower += 10;
                        break;
                    case "Escudo Protector":
                        this.lifePoints += 5;  // O restar 5 al daño recibido
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

    public int getLifePoints() {
        return lifePoints;
    }

    public int getAttackPower() {
        return attackPower;
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

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
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
}
