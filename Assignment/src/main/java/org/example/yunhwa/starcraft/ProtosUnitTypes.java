package org.example.yunhwa.starcraft;

public class ProtosUnitTypes implements RaceUnitType { // Zealot Dragoon HighTempler Scout Corsair

    Zealot zealot;
    Dragoon dragoon;
    HighTempler highTempler;
    Scout scout;
    Corsair corsair;
    Carrier carrier;

    @Override
    public int getRaceUnitTypeCount() {
        return ProtosUnitTypes.class.getDeclaredFields().length;
    }

    @Override
    public int getMakeUnitCount() {
        return 4;
    }

}
