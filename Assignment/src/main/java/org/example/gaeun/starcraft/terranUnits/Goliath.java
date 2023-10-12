package org.example.gaeun.starcraft.terranUnits;

import org.example.gaeun.starcraft.Unit;

public class Goliath extends Unit {
    public Goliath() {
        super("goliath", 5, 15);
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
