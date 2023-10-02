package org.example.Jminsoo.starcraft.terran;

import org.example.Jminsoo.starcraft.stateType.Flyable;
import org.example.Jminsoo.starcraft.stateType.Unit;

public class Wraith implements Flyable {
    private int defense;
    private final int attack;
    private String name;

    public Wraith() {
        this.defense = 10;
        this.attack = 3;
        this.name = "Wraith";
    }

    public void attack(Unit unit) {
        unit.hit(this.getAttack());
    }


    public boolean isDie() {
        if (defense <= 0) {
            System.out.printf("%s가 파괴되었습니다!%n", getName());
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
    public String getName() {
        return this.name;
    }


}
