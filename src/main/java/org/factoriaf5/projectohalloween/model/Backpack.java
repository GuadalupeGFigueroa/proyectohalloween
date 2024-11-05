package org.factoriaf5.projectohalloween.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Backpack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "aiden_id")
    private Aiden aiden;

    @ElementCollection
    private List<Object> items = new ArrayList<>();

    public Backpack() {
    }

    public Backpack(Aiden aiden) {
        this.aiden = aiden;
    }

    public Long getId() {
        return id;
    }

    public Aiden getAiden() {
        return aiden;
    }

    public List<Object> getItems() {
        return items;
    }

    public boolean addItem(Object item) {
        if (items.size() < 3) {
            items.add(item);
            return true;
        }
        return false;
    }

    public boolean removeItem(Object item) {
        return items.remove(item);
    }
}