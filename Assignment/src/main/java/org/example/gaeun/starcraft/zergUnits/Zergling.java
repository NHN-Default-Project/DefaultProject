package org.example.gaeun.starcraft.zergUnits;

import org.example.gaeun.starcraft.Unit;

public class Zergling extends Unit {
    public Zergling() {
        super("zergling", 2, 2);
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
