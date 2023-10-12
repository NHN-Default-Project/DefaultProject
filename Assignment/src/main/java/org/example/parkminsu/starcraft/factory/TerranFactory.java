package org.example.parkminsu.starcraft.factory;

import org.example.parkminsu.starcraft.Unit;
import org.example.parkminsu.starcraft.terran.*;

public class TerranFactory {
    public Unit createTerranUnit(String type) { // 테란 유닛 생성
        if (type.equalsIgnoreCase("Marine")) {
            return new Marine();
        } else if (type.equalsIgnoreCase("Tank")) {
            return new Tank();
        } else if (type.equalsIgnoreCase("Goliath")) {
            return new Goliath();
        } else if (type.equalsIgnoreCase("Wraith")) {
            return new Wraith();
        } else if (type.equalsIgnoreCase("Valkyrie")) {
            return new Valkyrie();
        } else if (type.equalsIgnoreCase("BattleCruzer")) {
            return new BattleCruzer();
        }
        return null;
    }
}
