package org.factoriaf5.projectohalloween;

public abstract class villains {
    protected int lifePoints;
    protected int attackPoints;

    public Villano(int lifePoints, int attackPoints) {
        this.lifePoints = lifePoints;
        this.attackPoints = attackPoints;
    }

    public void atacar(Aiden player) {
        player.recibirDaño(this.attackPoints);
    }

    public void recibirDaño(int cantidad) {
        this.lifePoints -= cantidad;
        if (this.lifePoints < 0) {
            this.lifePoints = 0;
        }
    }

    public abstract void derrotado(Aiden player);

    public int getlifePoints() {
        return this.lifePoints;
    }
}
