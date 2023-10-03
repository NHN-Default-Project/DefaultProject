package org.example.yunhwa.starCraft;

public class TerranUnitTypes implements RaceUnitType { // Marine Tank Goliath Wraith Valkyrie

    Marine marine;
    Tank tank;
    Goliath goliath;
    Wraith wraith;
    Valkyrie valkyrie;

    @Override
    public int getRaceUnitTypeCount() {
        return TerranUnitTypes.class.getDeclaredFields().length;
    }

    @Override
    public int getMakeUnitCount() {
        return 5;
    }
}
