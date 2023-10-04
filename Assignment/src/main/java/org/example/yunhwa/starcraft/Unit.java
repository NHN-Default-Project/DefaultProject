package org.example.yunhwa.starcraft;

public abstract class Unit {
    private int attackPower;
    private int defensePower;

    public Unit(int attackPower, int defensePower) {
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    public void printCurrentDefensePower() {
        System.out.printf("%s (현재 방어력: %d) %n", this.getClass().getSimpleName(), this.defensePower);
    }

    public int getAttackPower() {
        return this.attackPower;
    }

    public int getDefensePower() {
        return this.defensePower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }
}
