package org.factoriaf5.projectohalloween.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = Protectiveshield)

public class Protectiveshield {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_protectiveshield")
    private Long id;

    private String name;
    private String type;
    private String effect;

    @ManyToOne
    @JoinColumn(name = "id_ability")
    private Ability ability;

    public Protectiveshield(Long id, String name, String type, String effect, Ability ability) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.effect = effect;
        this.ability = ability;
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

    public Ability getAbility() {
        return ability;
    }

    public void setAbility(Ability ability) {
        this.ability = ability;
    }
}
