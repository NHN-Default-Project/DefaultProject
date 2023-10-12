package org.example.gaeun.starcraft.zergUnits;

import org.example.gaeun.starcraft.Unit;

public class Ultralisk extends Unit {
    public Ultralisk() {
        super("ultralisk", 5, 15);
    }

    @Override
    public boolean canFly() {
        return false;
    }

    @Override
    public boolean hasItems() {
        return false;
    }
}
