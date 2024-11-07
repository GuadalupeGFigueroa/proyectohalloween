package org.factoriaf5.projectohalloween.model;

public class GameObject {
    private String name;
    private String type;
    private String effect;

    public GameObject(String name, String type, String effect) {
        this.name = name;
        this.type = type;
        this.effect = effect;
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