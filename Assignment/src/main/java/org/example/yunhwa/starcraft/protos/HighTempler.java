package org.example.yunhwa.starcraft.protos;

import org.example.yunhwa.starcraft.NotFlyable;
import org.example.yunhwa.starcraft.Protos;
import org.example.yunhwa.starcraft.Unit;

public class HighTempler extends Unit implements Protos, NotFlyable {
    public HighTempler() {
        super(10, 2);
    }
}
