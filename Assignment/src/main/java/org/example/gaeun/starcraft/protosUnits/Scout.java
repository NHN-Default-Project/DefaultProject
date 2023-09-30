package org.example.gaeun.starcraft.protosUnits;

import org.example.gaeun.starcraft.Unit;

public class Scout extends Unit {
    public Scout() {
        super("scout", 5, 10);
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
