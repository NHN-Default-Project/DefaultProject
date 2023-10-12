package org.example.parkminsu.starcraft.factory;

import org.example.parkminsu.starcraft.Unit;
import org.example.parkminsu.starcraft.zerg.*;

public class ZergFactory {
    public Unit createZergUnit(String zergUnit) {
        if (zergUnit.equalsIgnoreCase("Zergling")) {
            return new Zergling();
        } else if (zergUnit.equalsIgnoreCase("Hydralisk")) {
            return new Hydralisk();
        } else if (zergUnit.equalsIgnoreCase("Mutalisk")) {
            return new Mutalisk();
        } else if (zergUnit.equalsIgnoreCase("Ultralisk")) {
            return new Ultralisk();
        } else if (zergUnit.equalsIgnoreCase("Guardian")) {
            return new Guardian();
        } else if (zergUnit.equalsIgnoreCase("Queen")) {
            return new Queen();
        }
        return null;
    }
}
