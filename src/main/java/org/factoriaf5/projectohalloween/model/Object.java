package org.factoriaf5.projectohalloween.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Object")

public class Object {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_object")
    
    private int id;
    private String name;
    private String type;
    private String efect;


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

    public Object() {
    }

    public Object(String name, String type, String efect) {
        this.name = name;
        this.type = type;
        this.efect = efect;
    }
    
}

