package org.example.gaeun.starcraft.protosUnits;

import org.example.gaeun.starcraft.Unit;

public class HighTempler extends Unit {
    public HighTempler() {
        super("hightempler", 10, 2);
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
