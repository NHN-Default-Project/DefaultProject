package org.example.gaeun.starcraft;

import org.example.gaeun.starcraft.ablity.Flyable;
import org.example.gaeun.starcraft.ablity.ItemHolder;

public abstract class Unit implements Flyable, ItemHolder {
    private String name;
    private int attackPow;

    private int defensivePow;
    public String getName() {
        return name;
    }

    public int getAttackPow() {
        return attackPow;
    }

    public int getDefensivePow() {
        return defensivePow;
    }
    public int setDefensivePow(int defensivePow) {
        this.defensivePow -= defensivePow;
        return this.defensivePow;
    }

    protected Unit(String name, int attackPow, int defensivePow) {
        this.name = name;
        this.attackPow = attackPow;
        this.defensivePow = defensivePow;
    }
    public void printStatus() {
        System.out.printf("%s (현재 방어력: %d)\n", getName(), getDefensivePow());
    }

}
