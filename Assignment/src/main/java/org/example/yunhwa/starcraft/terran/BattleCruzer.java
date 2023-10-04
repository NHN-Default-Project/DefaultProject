package org.example.yunhwa.starcraft.terran;

import org.example.yunhwa.starcraft.Flyable;
import org.example.yunhwa.starcraft.Terran;
import org.example.yunhwa.starcraft.Unit;

public class BattleCruzer extends Unit implements Terran, Flyable {
    public BattleCruzer() {
        super(20, 30);
    }
}
