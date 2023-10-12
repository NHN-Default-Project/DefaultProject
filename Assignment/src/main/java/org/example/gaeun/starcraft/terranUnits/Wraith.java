package org.example.gaeun.starcraft.terranUnits;

import org.example.gaeun.starcraft.Unit;

public class Wraith extends Unit {
    public Wraith() {
        super("wraith", 3, 10);
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
