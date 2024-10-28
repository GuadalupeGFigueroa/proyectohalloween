package org.factoriaf5.projectohalloween.model;

public class Stage {


    private String name;
    private int enemies;
    private int attackPower;

    public Stage() {
    }

    public Stage (String nombre, int enemies, int attackPower){
        this.name=nombre;
        this.enemies=enemies;
        this.attackPower=attackPower;
    }

    public String getNombre(){
        return name;
    }

    public int getEnemies(){
        return enemies;
    }

    public int getAttackPower(){
        return attackPower;
    }

    public void information (){
    System.out.println("Nivel "+ name);
    System.out.println("Numero de enemigos "+ enemies);
    System.out.println("poder de ataque "+ attackPower);
    }
}
