package org.example.jaehyeon.starcraft;

public abstract class Unit {

    int attackPower;
    int defensePower;

    public void beAttacked(int attackPower){
        this.defensePower -= attackPower;
    }

    public void setAbility(int extraAttackPower, int extraDefensePower){
        this.attackPower += extraAttackPower;
        this.defensePower += extraDefensePower;
    }



}
