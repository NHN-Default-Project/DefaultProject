package org.example.yunhwa.starcraft;

public interface NotFlyable {
    // * 미사일, 레이저 포 또는 침을 가진 유닛은 날 수 있는 유닛을 공격할 수 있게 추가로 재정의 필요
    default boolean canAttackFlyable() {
        return false;
    }

    default boolean canLaunchMissile() {
        return false;
    }

    default boolean canFireLaser() {
        return false;
    }

    default boolean canShootNeedle() {
        return false;
    }
}