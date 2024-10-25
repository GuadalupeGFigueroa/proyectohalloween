package org.factoriaf5.projectohalloween.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="Health_Potion")

public class Health_Potion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_HealthPotion")

    private int id;
    private String name;
    private String type;
    private String efect;
    
    @ManyToOne
    @JoinColumn(name = "id_Object")
    private Object object;

    public Health_Potion(int id, String name, String type, String efect, Object object) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.efect = efect;
        this.object = object;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getEfect() {
        return efect;
    }

    public void setEfect(String efect) {
        this.efect = efect;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}