package org.example.yunhwa.starcraft.terran;

import org.example.yunhwa.starcraft.Flyable;
import org.example.yunhwa.starcraft.Terran;
import org.example.yunhwa.starcraft.Unit;

public class Wraith extends Unit implements Terran, Flyable {
    public Wraith() {
        super(3, 10);
    }
}
