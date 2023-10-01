package org.example.jaehyeon.tribe;

import org.example.jaehyeon.starcraft.terran.*;
import java.util.ArrayList;

public class Terran extends Tribe {

    private static final String[] UNIT = {"marine", "tank", "goliath", "wraith", "valkyrie"};
    private static final int PRODUCTION_NUMBER = 5;

    public Terran() {
        unitList = new ArrayList<>();
        for (int i = 0; i < PRODUCTION_NUMBER; i++) {
            unitList.add(randomProductionUnit(UNIT));
        }
    }

    public Marine marine() {
        return new Marine();
    }

    public Tank tank() {
        return new Tank();
    }

    public Valkyrie valkyrie() {
        return new Valkyrie();
    }

    public Goliath goliath() {
        return new Goliath();
    }

    public Wraith wraith() {
        return new Wraith();
    }
}
