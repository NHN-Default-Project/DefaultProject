package org.example.jaehyeon.starcraft.protoss;

import org.example.jaehyeon.starcraft.Unit;

public class Dragoon extends Unit {
    private static final int EXTRA_ATTACK_POWER = 3;
    private static final int EXTRA_DEFENSE_POWER = 15;

    public Dragoon() {
        setAbility(EXTRA_ATTACK_POWER, EXTRA_DEFENSE_POWER);
    }
}