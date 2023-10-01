package org.example.jaehyeon.starcraft.zerg;

import org.example.jaehyeon.starcraft.Unit;

public class Zergling extends Unit {

    private static final int EXTRA_ATTACK_POWER = 2;
    private static final int EXTRA_DEFENSE_POWER = 2;

    public Zergling() {
        setAbility(EXTRA_ATTACK_POWER, EXTRA_DEFENSE_POWER);
    }
}
