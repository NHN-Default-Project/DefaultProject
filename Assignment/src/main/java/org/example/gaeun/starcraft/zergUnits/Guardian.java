package org.example.gaeun.starcraft.zergUnits;

import org.example.gaeun.starcraft.Unit;

public class Guardian extends Unit {
    public Guardian() {
        super("guardian", 3, 6);
    }

    @Override
    public boolean canFly() {
        return true;
    }

    @Override
    public boolean hasItems() {
        return false;
    }
}
