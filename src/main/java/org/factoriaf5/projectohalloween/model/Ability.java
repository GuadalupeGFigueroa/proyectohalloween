package org.factoriaf5.projectohalloween.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ability")

public class Ability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    
    @Column (name = "id_ability")
    private Long id;
    private String name;
    private String type;
    private String effect;
    
    
    public Ability() {
    }

    public Ability(Long id, String name, String type, String effect) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.effect = effect;
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

    

}
