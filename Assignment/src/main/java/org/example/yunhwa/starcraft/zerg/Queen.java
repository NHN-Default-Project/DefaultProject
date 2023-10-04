package org.example.yunhwa.starcraft.zerg;

import org.example.yunhwa.starcraft.Flyable;
import org.example.yunhwa.starcraft.Unit;
import org.example.yunhwa.starcraft.Zerg;

public class Queen extends Unit implements Zerg, Flyable {
    public Queen() {
        super(15, 25);
    }

}