package org.example.yunhwa.starcraft.zerg;

import org.example.yunhwa.starcraft.NotFlyable;
import org.example.yunhwa.starcraft.Unit;
import org.example.yunhwa.starcraft.Zerg;

public class Ultralisk extends Unit implements org.example.yunhwa.starcraft.Zerg, NotFlyable {
    public Ultralisk() {
        super(5, 15);
    }
}
