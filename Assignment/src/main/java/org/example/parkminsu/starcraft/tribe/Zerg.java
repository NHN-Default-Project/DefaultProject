package org.example.parkminsu.starcraft.tribe;

import org.example.parkminsu.starcraft.Unit;
import org.example.parkminsu.starcraft.factory.ZergFactory;

import java.util.ArrayList;
import java.util.List;

public class Zerg {
    private ZergFactory zergFactory;
    private final String[] zergUnit = {"Zergling", "Hydralisk", "Mutalisk", "Guardian", "Ultralisk", "Queen"};
    private final int numberOfZergUnitsCreated = 8;

    public List<Unit> createZergUnit() {
        this.zergFactory = new ZergFactory();
        List<Unit> zergUnitList = new ArrayList<>();
        for (int i = 0; i < numberOfZergUnitsCreated; i++) {
            int num = (int) (Math.random() * this.zergUnit.length);
            zergUnitList.add(zergFactory.createZergUnit(zergUnit[num]));
        }
        return zergUnitList;
    }

}
