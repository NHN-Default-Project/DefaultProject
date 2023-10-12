package org.example.yunhwa.starcraft.zerg;

import org.example.yunhwa.starcraft.NotFlyable;
import org.example.yunhwa.starcraft.Unit;
import org.example.yunhwa.starcraft.Zerg;

public class Hydralisk extends Unit implements Zerg, NotFlyable {
    public Hydralisk() {
        super(3, 7);
    }

    @Override
    public boolean canShootNeedle() {
        return true;
    }

    @Override
    public boolean canAttackFlyable() {
        return true;
    }
}