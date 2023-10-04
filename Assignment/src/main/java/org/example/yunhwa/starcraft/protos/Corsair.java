package org.example.yunhwa.starcraft.protos;

import org.example.yunhwa.starcraft.Flyable;
import org.example.yunhwa.starcraft.Protos;
import org.example.yunhwa.starcraft.Unit;

public class Corsair extends Unit implements Protos, Flyable {
    public Corsair() {
        super(4, 12);
    }
}
