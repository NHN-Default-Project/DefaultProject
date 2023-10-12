package org.example.parkminsu.starcraft.factory;

import org.example.parkminsu.starcraft.Unit;
import org.example.parkminsu.starcraft.protos.*;

public class ProtosFactory {

    public Unit createProtosUnit(String protosUnit) { // 플토 유닛 생성

        if (protosUnit.equalsIgnoreCase("zealot")) {
            return new Zealot();
        } else if (protosUnit.equalsIgnoreCase("dragoon")) {
            return new Dragoon();
        } else if (protosUnit.equalsIgnoreCase("highTempler")) {
            return new HighTempler();
        } else if (protosUnit.equalsIgnoreCase("scout")) {
            return new Scout();
        } else if (protosUnit.equalsIgnoreCase("corsair")) {
            return new Corsair();
        } else if (protosUnit.equalsIgnoreCase("carrier")) {
            return new Carrier();
        }
        return null;
    }
}
