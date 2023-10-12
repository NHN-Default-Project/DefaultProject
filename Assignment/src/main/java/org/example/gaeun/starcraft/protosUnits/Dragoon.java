package org.example.gaeun.starcraft.protosUnits;

import org.example.gaeun.starcraft.Unit;

public class Dragoon extends Unit {
    public Dragoon() {
        super("dragoon", 3, 15);
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
