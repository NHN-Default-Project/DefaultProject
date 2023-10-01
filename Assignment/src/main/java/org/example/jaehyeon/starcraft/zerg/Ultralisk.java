package org.example.jaehyeon.starcraft.zerg;

import org.example.jaehyeon.starcraft.Unit;

public class Ultralisk extends Unit {
    private static final int EXTRA_ATTACK_POWER = 5;
    private static final int EXTRA_DEFENSE_POWER = 15;

    public Ultralisk() {
        setAbility(EXTRA_ATTACK_POWER, EXTRA_DEFENSE_POWER);
    }
}
