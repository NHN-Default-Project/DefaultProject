package org.example.Jminsoo.starcraft.terran;

import org.example.Jminsoo.starcraft.stateType.Flyable;
import org.example.Jminsoo.starcraft.stateType.Unit;

public class Wraith<S extends Unit> implements Flyable<S> {
    private int defense;
    private final int attack;
    private String name;

    public Wraith() {
        this.defense = 10;
        this.attack = 3;
        this.name = "Wraith";
    }

    @Override
    public void attack(S unit) {

    }

    public boolean isDie() {
        if (defense < 0) {
            return true;
        } else {
            return false;
        }
    }

    public void hit(int attack) {
        this.defense = this.defense - attack;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (현재 방어력 : %d, 공격력 : %d)", this.name, this.defense, this.attack));
        return sb.toString();
    }
}
