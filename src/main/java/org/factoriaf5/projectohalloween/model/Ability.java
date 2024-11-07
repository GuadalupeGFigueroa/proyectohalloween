package org.factoriaf5.projectohalloween.model;





import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table(name = "Ability")
public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private String effect;
    private int cooldown;
    private int duration;
    private int remainingCooldown;
    private int activeTurnsLeft;

    @ManyToOne
    @JoinColumn(name = "aiden_id")
    private Aiden aiden;

    public Ability() {
    }

    public Ability(String name, String type, String effect, int cooldown, int duration) {
        this.name = name;
        this.type = type;
        this.effect = effect;
        this.cooldown = cooldown;
        this.duration = duration;
        this.remainingCooldown = 0;
        this.activeTurnsLeft = 0;
    }

    public void activate() {
        if (remainingCooldown == 0) {
            activeTurnsLeft = duration;
            remainingCooldown = cooldown;
        }
    }

    public void decreaseCooldown() {
        if (remainingCooldown > 0) {
            remainingCooldown--;
        }
        if (activeTurnsLeft > 0) {
            activeTurnsLeft--;
        }
    }

    public boolean isAvailable() {
        return remainingCooldown == 0;
    }

    public boolean isActive() {
        return activeTurnsLeft > 0;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getRemainingCooldown() {
        return remainingCooldown;
    }

    public void setRemainingCooldown(int remainingCooldown) {
        this.remainingCooldown = remainingCooldown;
    }

    public int getActiveTurnsLeft() {
        return activeTurnsLeft;
    }

    public void setActiveTurnsLeft(int activeTurnsLeft) {
        this.activeTurnsLeft = activeTurnsLeft;
    }
}