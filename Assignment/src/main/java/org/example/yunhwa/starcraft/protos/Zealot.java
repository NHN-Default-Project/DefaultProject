package org.example.yunhwa.starcraft.protos;

import org.example.yunhwa.starcraft.NotFlyable;
import org.example.yunhwa.starcraft.Protos;
import org.example.yunhwa.starcraft.Unit;

public class Zealot extends Unit implements Protos, NotFlyable {
    public Zealot() {
        super(5, 20);
    }
}