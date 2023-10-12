package org.example.yunhwa.starcraft.protos;

import org.example.yunhwa.starcraft.Flyable;
import org.example.yunhwa.starcraft.Protos;
import org.example.yunhwa.starcraft.Unit;

public class Scout extends Unit implements Protos, Flyable {
    public Scout() {
        super(5, 10);
    }
}
