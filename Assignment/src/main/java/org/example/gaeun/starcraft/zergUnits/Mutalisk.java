package org.example.gaeun.starcraft.zergUnits;

import org.example.gaeun.starcraft.Unit;

public class Mutalisk extends Unit {
    public Mutalisk() {
        super("mutalisk", 2, 8);
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
