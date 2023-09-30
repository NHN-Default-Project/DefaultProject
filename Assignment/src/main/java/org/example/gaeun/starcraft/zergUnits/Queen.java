package org.example.gaeun.starcraft.zergUnits;

import org.example.gaeun.starcraft.Unit;

public class Queen extends Unit {
    public Queen() {
        super("queen", 15, 25);
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
