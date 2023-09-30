package org.example.gaeun.starcraft.terranUnits;

import org.example.gaeun.starcraft.Unit;

public class BattleCruzer extends Unit {
    public BattleCruzer() {
        super("battleCruzer", 20, 30);
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
