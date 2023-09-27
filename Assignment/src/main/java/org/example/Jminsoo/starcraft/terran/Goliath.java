package org.example.Jminsoo.starcraft.terran;

import org.example.Jminsoo.starcraft.attackType.CanAttackFlyable;
import org.example.Jminsoo.starcraft.raceType.Terran;
import org.example.Jminsoo.starcraft.stateType.Unit;
import org.example.Jminsoo.starcraft.stateType.Walkable;

public class Goliath<S extends Unit & Walkable<S>> implements CanAttackFlyable<S>, Walkable<S>, Terran {
    private int defense;
    private final int attack;
    private final String name;

    public Goliath() {
        this.attack = 5;
        this.defense = 15;
        this.name = "Goliath";
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

    @Override
    public void attack(S unit) {
        unit.hit(this.getAttack());
    }

}
