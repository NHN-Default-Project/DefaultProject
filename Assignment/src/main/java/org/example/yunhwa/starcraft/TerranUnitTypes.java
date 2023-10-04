package org.example.yunhwa.starcraft;

import org.example.yunhwa.starcraft.terran.BattleCruzer;
import org.example.yunhwa.starcraft.terran.Marine;
import org.example.yunhwa.starcraft.terran.Goliath;
import org.example.yunhwa.starcraft.terran.Tank;
import org.example.yunhwa.starcraft.terran.Valkyrie;
import org.example.yunhwa.starcraft.terran.Wraith;

public class TerranUnitTypes implements RaceUnitType { // Marine Tank Goliath Wraith Valkyrie

    Marine marine;
    Tank tank;
    Goliath goliath;
    Wraith wraith;
    Valkyrie valkyrie;
    BattleCruzer battleCruzer;

    @Override
    public int getRaceUnitTypeCount() {
        return TerranUnitTypes.class.getDeclaredFields().length;
    }

    @Override
    public int getMakeUnitCount() {
        return 5;
    }
}