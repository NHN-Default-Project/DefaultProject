package org.example.yunhwa.starcraft.terran;

import org.example.yunhwa.starcraft.Flyable;
import org.example.yunhwa.starcraft.Terran;
import org.example.yunhwa.starcraft.Unit;

public class Valkyrie extends Unit implements Terran, Flyable {
    public Valkyrie() {
        super(4, 12);
    }
}
