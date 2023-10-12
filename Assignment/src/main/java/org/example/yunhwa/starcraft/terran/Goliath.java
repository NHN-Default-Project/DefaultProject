package org.example.yunhwa.starcraft.terran;

import org.example.yunhwa.starcraft.NotFlyable;
import org.example.yunhwa.starcraft.Terran;
import org.example.yunhwa.starcraft.Unit;

public class Goliath extends Unit implements Terran, NotFlyable {
    public Goliath() {
        super(5, 15);
    }

    @Override
    public boolean canLaunchMissile() {
        return true;
    }

    @Override
    public boolean canAttackFlyable() {
        return true;
    }
}
