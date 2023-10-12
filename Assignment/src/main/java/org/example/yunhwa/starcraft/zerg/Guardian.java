package org.example.yunhwa.starcraft.zerg;

import org.example.yunhwa.starcraft.Flyable;
import org.example.yunhwa.starcraft.Unit;
import org.example.yunhwa.starcraft.Zerg;

public class Guardian extends Unit implements Zerg, Flyable {
    public Guardian() {
        super(3, 6);
    }
}
