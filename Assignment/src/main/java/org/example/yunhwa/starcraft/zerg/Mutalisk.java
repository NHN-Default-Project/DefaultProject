package org.example.yunhwa.starcraft.zerg;

import org.example.yunhwa.starcraft.Flyable;
import org.example.yunhwa.starcraft.Unit;
import org.example.yunhwa.starcraft.Zerg;

public class Mutalisk extends Unit implements Zerg, Flyable {
    public Mutalisk() {
        super(2, 8);
    }
}