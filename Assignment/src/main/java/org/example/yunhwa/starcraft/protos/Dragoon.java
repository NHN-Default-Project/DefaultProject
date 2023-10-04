package org.example.yunhwa.starcraft.protos;

import org.example.yunhwa.starcraft.NotFlyable;
import org.example.yunhwa.starcraft.Protos;
import org.example.yunhwa.starcraft.Unit;

public class Dragoon extends Unit implements Protos, NotFlyable {
    public Dragoon() {
        super(3, 15);
    }

    @Override
    public boolean canFireLaser() {
        return true;
    }

    @Override
    public boolean canAttackFlyable() {
        return true;
    }
}
