package org.example.jaehyeon.starcraft.protoss;

import org.example.jaehyeon.starcraft.Unit;

public class Scout extends Unit {
    private static final int EXTRA_ATTACK_POWER = 5;
    private static final int EXTRA_DEFENSE_POWER = 20;

    public Scout() {
        setAbility(EXTRA_ATTACK_POWER, EXTRA_DEFENSE_POWER);
    }
}
