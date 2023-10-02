package org.example.jaehyeon.starcraft.unit.terran;

import org.example.jaehyeon.starcraft.unit.Unit;

public class Tank extends Unit {
    private static final int EXTRA_ATTACK_POWER = 7;
    private static final int EXTRA_DEFENSE_POWER = 15;

    public Tank() {
        setAbility(EXTRA_ATTACK_POWER, EXTRA_DEFENSE_POWER);
        setItem();
        setCanFly();
    }
}
