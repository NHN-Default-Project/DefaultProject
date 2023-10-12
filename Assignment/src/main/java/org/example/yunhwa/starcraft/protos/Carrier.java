package org.example.yunhwa.starcraft.protos;

import org.example.yunhwa.starcraft.Flyable;
import org.example.yunhwa.starcraft.Protos;
import org.example.yunhwa.starcraft.Unit;

public class Carrier extends Unit implements Protos, Flyable {
    public Carrier() {
        super(25, 40);
    }
}
