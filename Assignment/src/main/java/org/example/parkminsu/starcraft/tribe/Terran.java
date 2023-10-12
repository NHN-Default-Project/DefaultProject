package org.example.parkminsu.starcraft.tribe;

import org.example.parkminsu.starcraft.Unit;
import org.example.parkminsu.starcraft.factory.TerranFactory;

import java.util.ArrayList;
import java.util.List;

public class Terran {
    private final String[] terranUnit = {"Marine", "Tank", "Goliath", "Wraith", "Valkyrie", "BattleCruzer"};
    private final TerranFactory terranFactory;
    private final int numberOfTerranUnitsCreated;

    public Terran() {
        numberOfTerranUnitsCreated = 5;
        this.terranFactory = new TerranFactory();
    }

    public List<Unit> createTerranUnit() {
        List<Unit> terranUnitList = new ArrayList<>();
        for (int i = 0; i < numberOfTerranUnitsCreated; i++) {
            int num = (int) (Math.random() * this.terranUnit.length);
            terranUnitList.add(this.terranFactory.createTerranUnit(this.terranUnit[num]));

        }
        return terranUnitList;
    }
}
