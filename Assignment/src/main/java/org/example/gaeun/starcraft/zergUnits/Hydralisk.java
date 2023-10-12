package org.example.gaeun.starcraft.zergUnits;

import org.example.gaeun.starcraft.Unit;

public class Hydralisk extends Unit {
    public Hydralisk() {
        super("hydralisk", 3, 7);
    }

    @Override
    public boolean canFly() {
        return false;
    }

    @Override
    public boolean hasItems() {
        return true;
    }
}
