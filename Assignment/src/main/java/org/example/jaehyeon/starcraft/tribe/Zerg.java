package org.example.jaehyeon.starcraft.tribe;

import org.example.jaehyeon.starcraft.zerg.*;

import java.util.ArrayList;

public class Zerg extends Tribe {

    private static final String[] UNIT = {"zergling", "hydralisk", "ultralisk", "mutalisk", "guardian"};
    private static final int PRODUCTION_NUMBER = 8;

    public Zerg() {
        unitList = new ArrayList<>();
        addUnit(PRODUCTION_NUMBER, UNIT);
    }

    public Zergling zergling() {
        return new Zergling();
    }

    public Hydralisk hydralisk() {
        return new Hydralisk();
    }

    public Ultralisk ultralisk() {
        return new Ultralisk();
    }

    public Mutalisk mutalisk() {
        return new Mutalisk();
    }

    public Guardian guardian() {
        return new Guardian();
    }
}
