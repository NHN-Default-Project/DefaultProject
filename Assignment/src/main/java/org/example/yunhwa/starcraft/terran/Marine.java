package org.example.yunhwa.starcraft.terran;

import org.example.yunhwa.starcraft.NotFlyable;
import org.example.yunhwa.starcraft.Terran;
import org.example.yunhwa.starcraft.Unit;

public class Marine extends Unit implements Terran, NotFlyable {
    public Marine() {
        super(3, 10);
    }
}
