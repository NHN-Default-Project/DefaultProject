package org.example.Jminsoo.starcraft.terran;

import org.example.Jminsoo.starcraft.attackType.CanAttackFlyable;
import org.example.Jminsoo.starcraft.stateType.Unit;
import org.example.Jminsoo.starcraft.stateType.Walkable;

public class Goliath implements CanAttackFlyable, Walkable {

    /*
    TODO: 지상 유닛은 공중 유닛을 공격 못하게 변경하라!!!!
    * */
    private int defense;
    private final int attack;
    private final String name;

    public Goliath() {
        this.attack = 5;
        this.defense = 15;
        this.name = "Goliath";
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
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (현재 방어력 : %d, 공격력 : %d)", this.name, this.defense, this.attack));
        return sb.toString();
    }

    @Override
    public void attack(Unit unit) {
        if (this.canAttackFlayble) {
            unit.hit(this.getAttack());
        } else {
            System.out.println("공격이 빗나갔습니다!");
        }
    }

}
