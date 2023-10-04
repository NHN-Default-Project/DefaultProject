package org.example.Jminsoo.starcraft.factories;

import org.example.Jminsoo.starcraft.unit.Unit;
import org.example.Jminsoo.starcraft.unit.protos.*;

public class ProtosFactory extends UnitFactory {
    String[] units;

    public ProtosFactory() {
        units = new String[]{"Corsair", "Dragoon", "HighTempler", "Scout", "Zealot", "Carrier"};
    }

    public String[] getUnitNames() {
        return units;
    }

    protected Unit createUnit(String name) {
        Unit unit = null;

        switch (name) {
            case "Corsair":
                unit = new Corsair();
                break;
            case "Dragoon":
                unit = new Dragoon();
                break;
            case "HighTempler":
                unit = new HighTempler();
                break;
            case "Scout":
                unit = new Scout();
                break;
            case "Zealot":
                unit = new Zealot();
                break;
            case "Carrier":
                unit = new Carrier();
                break;
            default:
                throw new IllegalArgumentException("그런 유닛은 없습니다!");
        }

        return unit;
    }
}
