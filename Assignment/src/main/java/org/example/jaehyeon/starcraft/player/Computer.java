package org.example.jaehyeon.starcraft.player;

import org.example.jaehyeon.starcraft.tribe.Tribe;
import org.example.jaehyeon.starcraft.unit.Unit;

import java.util.Random;

public class Computer extends Player {
    public Computer(Tribe tribe) {
        setTribe(tribe);
    }

    public int chooseRandomNumber(Tribe tribe) {
        Random random = new Random();
        return random.nextInt(tribe.getUnitList().size());
    }
}
