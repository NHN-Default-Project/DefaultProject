package org.example.gaeun.starcraft.protosUnits;

import org.example.gaeun.starcraft.Unit;

public class Carrier extends Unit {
    public Carrier() {
        super("carrier", 25, 40);
    }

    @Override
    public boolean canFly() {
        return true;
    }

    @Override
    public boolean hasItems() {
        return true;
    }
}
