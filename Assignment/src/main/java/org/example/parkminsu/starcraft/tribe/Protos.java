package org.example.parkminsu.starcraft.tribe;

import org.example.parkminsu.starcraft.Unit;
import org.example.parkminsu.starcraft.factory.ProtosFactory;

import java.util.ArrayList;
import java.util.List;

public class Protos {
    private ProtosFactory protosFactory;
    private final String[] protosUnit = {"Zealot", "Dragoon", "HighTempler", "Scout", "Corsair", "Carrier"};

    private final int numberOfProtosUnitsCreated;

    public Protos() {
        this.protosFactory = new ProtosFactory();
        this.numberOfProtosUnitsCreated = 4;

    }

    public List<Unit> createProtosUnit() {
        this.protosFactory = new ProtosFactory();
        List<Unit> protosUnitList = new ArrayList<>();
        for (int i = 0; i < this.numberOfProtosUnitsCreated; i++) {
            int num = (int) (Math.random() * this.protosUnit.length);
            protosUnitList.add(this.protosFactory.createProtosUnit(this.protosUnit[num]));
        }
        return protosUnitList;
    }

}
