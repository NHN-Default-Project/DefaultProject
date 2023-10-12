package org.example.gaeun.starcraft.terranUnits;

import org.example.gaeun.starcraft.Unit;

public class Tank extends Unit {
    public Tank() {
        super("tank", 7, 15);
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
