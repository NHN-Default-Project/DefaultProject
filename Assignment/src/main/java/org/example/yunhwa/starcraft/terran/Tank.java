package org.example.yunhwa.starcraft.terran;

import org.example.yunhwa.starcraft.NotFlyable;
import org.example.yunhwa.starcraft.Terran;
import org.example.yunhwa.starcraft.Unit;

public class Tank extends Unit implements Terran, NotFlyable {
    public Tank() {
        super(7, 15);
    }
}
