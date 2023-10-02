package org.example.jaehyeon.starcraft;

public abstract class Unit implements Item, Flyable {

    int attackPower;
    int defensePower;

    boolean canFly;
    boolean hasItem;

    public void attackUnit(Unit targetUnit) {
        if (!this.canFly) {
            if (targetUnit.canFly && !this.hasItem) {
                System.out.println("이 유닛은 공중에 있는 유닛을 공격을 못합니다.");
                return;
            }
        }
        attack(targetUnit);
    }



    public void attack(Unit targetUnit) {
        targetUnit.defensePower -= this.attackPower;
        if (targetUnit.defensePower <= 0) {
            System.out.println("파괴되었다");
        } else {
            System.out.println("공격했다");
        }
    }

    public void beAttacked() {
        this.defensePower -= attackPower;
        if (this.defensePower <= 0) {
            System.out.println("파괴되었다");
        } else {
            System.out.println("공격 당했다");
        }
    }

    public void setAbility(int extraAttackPower, int extraDefensePower) {
        this.attackPower += extraAttackPower;
        this.defensePower += extraDefensePower;
    }

    public boolean getHasItem() {
        return this.hasItem;
    }

    protected void setCanFly() {
        this.canFly = canFly();
    }

    protected void setItem() {
        this.hasItem = hasItem();
    }

    @Override
    public boolean canFly() {
        return false;
    }

    @Override
    public boolean hasItem() {
        return false;
    }


}
