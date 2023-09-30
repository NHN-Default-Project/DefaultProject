package org.example.gaeun.starcraft.terranUnits;

import org.example.gaeun.starcraft.Unit;

public class Marine extends Unit {
    public Marine() {
        super("marine", 3, 10);
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
