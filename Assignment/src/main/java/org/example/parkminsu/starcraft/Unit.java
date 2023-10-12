package org.example.parkminsu.starcraft;

public abstract class Unit implements Flyable, Attack { // item?
    private final boolean flyable;
    private final String name;
    private final int offensePower;
    private int defense;

    private boolean haveAirUnitAttackWeapon;

    protected Unit(String name, int offensePower, int defense, boolean flyable, boolean haveAirUnitAttackWeapon) {
        this.name = name;
        this.offensePower = offensePower;
        this.defense = defense;
        this.flyable = flyable;
        this.haveAirUnitAttackWeapon = haveAirUnitAttackWeapon;
    }


    public boolean isHaveAirUnitAttackWeapon() {
        return haveAirUnitAttackWeapon;
    }

    public boolean isFlyable() {
        return flyable;
    }

    public int getOffensePower() {
        return offensePower;
    }

    public int getDefense() {
        return defense;
    }

    public boolean dieUnit() {
        return getDefense() <= 0;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public boolean attackable(Unit unit) {// 상대 유닛에게 공격이 가능한지
        if (unit.isFlyable() && (!this.isFlyable() && !this.isHaveAirUnitAttackWeapon())) {
            return false;
        }
        return true;
    }

    @Override
    public void attack(Unit unit) {
        if (unit.dieUnit()) {
            throw new IllegalArgumentException("해당 유닛은 죽었습니다 다시 입력해주세여");
        }
        if (attackable(unit)) {
            unit.setDefense(unit.getDefense() - this.getOffensePower());
        } else {
            throw new IllegalArgumentException("해당 유닛은 날 수 있는 유닛을 공격할 수 없습니다.");
        }

    }

    @Override
    public boolean flyable() {
        return flyable;
    }

    @Override
    public String toString() {
        return name + " (현재 방어: " + defense + ")";
    }
}
