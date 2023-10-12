package org.example.gaeun.starcraft.terranUnits;

import org.example.gaeun.starcraft.Unit;

public class Valkyrie extends Unit {
    public Valkyrie() {
        super("valkyrie", 4, 12);
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
