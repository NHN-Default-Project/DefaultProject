package org.example.Jminsoo.starcraft.attackType;

import org.example.Jminsoo.starcraft.stateType.Unit;

public interface CanAttackFlyable<S extends Unit> {
    void attack(S unit);
}
