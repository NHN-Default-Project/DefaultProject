package org.example.yunhwa.starcraft;

import org.example.yunhwa.starcraft.zerg.*;

public class ZergUnitTypes implements RaceUnitType { // Zergling Hydralisk Ultralisk Mutalisk Guardian

    Zergling zergling;
    Hydralisk hydralisk;
    Ultralisk ultralisk;
    Mutalisk mutalisk;
    Guardian guardian;
    Queen queen;

    @Override
    public int getRaceUnitTypeCount() {
        return ZergUnitTypes.class.getDeclaredFields().length;
    }

    @Override
    public int getMakeUnitCount() {
        return 8;
    }
}