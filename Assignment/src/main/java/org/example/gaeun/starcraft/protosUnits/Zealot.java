package org.example.gaeun.starcraft.protosUnits;

import org.example.gaeun.starcraft.Unit;

public class Zealot extends Unit {
    public Zealot() {
        super("zealot", 5, 20);
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
