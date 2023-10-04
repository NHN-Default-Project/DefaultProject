package org.example.Jminsoo.starcraft.unit;

public abstract class Unit {
    protected int defense;
    protected int attack;
    protected String name;

    protected boolean canAttackFlyable;

    protected boolean flyable;

    public Unit(int defense, int attack, String name, boolean canAttackFlyable, boolean flyable) {
        this.defense = defense;
        this.attack = attack;
        this.name = name;
        this.canAttackFlyable = canAttackFlyable;
        this.flyable = flyable;
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

    public void attack(Unit unit) {
        if (this.getCanAttackFlyable()) {
            unit.hit(this.attack);
        } else if (!unit.getFlyable()) {
            unit.hit(this.attack);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {

        return this.defense;
    }

    public boolean getCanAttackFlyable() {
        return this.canAttackFlyable;
    }

    public boolean getFlyable() {
        return this.flyable;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (현재 방어력 : %d, 공격력 : %d)", this.name, this.defense, this.attack));
        return sb.toString();
    }

}
