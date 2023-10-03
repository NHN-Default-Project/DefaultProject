package org.example.Jminsoo.starcraft.factories;

import org.example.Jminsoo.starcraft.stateType.Unit;
import org.example.Jminsoo.starcraft.terran.*;

public class TerranFactory extends UnitFactory {

    String[] units;

    public TerranFactory() {
        units = new String[]{"Marine", "Goliath", "Tank", "Valkyrie", "Wraith"};
    }

    public String[] getUnitNames() {
        return units;
    }

    protected Unit createUnit(String name) {
        Unit unit = null;

        switch (name) {
            case "Marine":
                unit = new Marine();
                break;
            case "Goliath":
                unit = new Goliath();
                break;
            case "Tank":
                unit = new Tank();
                break;
            case "Valkyrie":
                unit = new Valkyrie();
                break;
            case "Wraith":
                unit = new Wraith();
                break;
            default:
                throw new IllegalArgumentException("그런 유닛은 없습니다!");
        }

        return unit;
    }
}
