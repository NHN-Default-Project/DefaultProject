package org.example.yunhwa.starcraft.zerg;

import org.example.yunhwa.starcraft.NotFlyable;
import org.example.yunhwa.starcraft.Unit;
import org.example.yunhwa.starcraft.Zerg;

public class Zergling extends Unit implements Zerg, NotFlyable {
    public Zergling() {
        super(2, 2);
    }
}
