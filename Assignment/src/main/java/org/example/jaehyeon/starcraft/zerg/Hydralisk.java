package org.example.jaehyeon.starcraft.zerg;

import org.example.jaehyeon.starcraft.Unit;

public class Hydralisk extends Unit {
    private static final int EXTRA_ATTACK_POWER = 3;
    private static final int EXTRA_DEFENSE_POWER = 7;

    public Hydralisk() {
        setAbility(EXTRA_ATTACK_POWER, EXTRA_DEFENSE_POWER);
    }
}
