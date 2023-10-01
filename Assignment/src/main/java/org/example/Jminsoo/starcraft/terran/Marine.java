package org.example.Jminsoo.starcraft.terran;

import org.example.Jminsoo.starcraft.stateType.Walkable;

public class Marine<S extends Walkable> implements Walkable<S> {

    private int defense;
    private final int attack;
    private String name;

    public Marine() {
        this.attack = 3;
        this.defense = 10;
        this.name = "Marine";
    }

    @Override
    public boolean isDie() {
        if (defense < 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void hit(int attack) {
        this.defense = this.defense - attack;
    }

    @Override
    public int getAttack() {
        return this.attack;
    }

    @Override
    public int getDefense() {
        return this.defense;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (현재 방어력 : %d, 공격력 : %d)", this.name, this.defense, this.attack));
        return sb.toString();
    }

    @Override
    public void attack(S unit) {
        unit.hit(this.getAttack());
    }
}
