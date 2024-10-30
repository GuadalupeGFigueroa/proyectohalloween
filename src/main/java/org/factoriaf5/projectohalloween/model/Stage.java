package org.factoriaf5.projectohalloween.model;
import jakarta.persistence.*;

@Entity
@Table(name="stages")
public class Stage {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private int level;

    public Stage() {
    }

    public Stage (String name, String description, int level){
        this.name=name;
        this.description=description;
        this.level=level;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
