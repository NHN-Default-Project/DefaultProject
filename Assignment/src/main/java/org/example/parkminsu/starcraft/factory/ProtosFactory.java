package org.example.parkminsu.starcraft.factory;

import org.example.parkminsu.starcraft.Unit;
import org.example.parkminsu.starcraft.protos.*;

public class ProtosFactory {
    public Unit createProtosUnit(String protosUnit) { // 플토 유닛 생성
        if (protosUnit.equalsIgnoreCase("Zealot")) {
            return new Zealot();
        } else if (protosUnit.equalsIgnoreCase("Dragoon")) {
            return new Dragoon();
        } else if (protosUnit.equalsIgnoreCase("HighTempler")) {
            return new HighTempler();
        } else if (protosUnit.equalsIgnoreCase("Scout")) {
            return new Scout();
        } else if (protosUnit.equalsIgnoreCase("Corsair")) {
            return new Corsair();
        } else if (protosUnit.equalsIgnoreCase("Carrier")) {
            return new Carrier();
        }
        return null;
    }
}
