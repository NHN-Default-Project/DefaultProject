package org.example.yunhwa.starCraft;

public interface Flyable {
    default boolean canAttackFlyable() {
        return true;
    }

    default boolean canAttackNotFlyable() {
        return true;
    }
}
