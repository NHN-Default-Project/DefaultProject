package org.example.parkminsu.starcraft.factory;

import org.example.parkminsu.starcraft.Unit;
import org.example.parkminsu.starcraft.protos.*;
import org.example.parkminsu.starcraft.terran.*;
import org.example.parkminsu.starcraft.zerg.*;

import java.util.ArrayList;
import java.util.List;

public class Factory {
    List<Unit> selectedTribeStandardUnitsList;
    private int numOfTerranUnit;
    private int numOfProtosUnit;
    private int numOfZergUnit;

    public List<Unit> createTerranUnit(String type) { // 테란 유닛 생성
        selectedTribeStandardUnitsList = new ArrayList<>();
        selectedTribeStandardUnitsList.add(new Marine());
        selectedTribeStandardUnitsList.add(new Tank());
        selectedTribeStandardUnitsList.add(new Goliath());
        selectedTribeStandardUnitsList.add(new Wraith());
        selectedTribeStandardUnitsList.add(new Valkyrie());
        selectedTribeStandardUnitsList.add(new BattleCruzer());
        return selectedTribeStandardUnitsList;
    }

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

    public List<Unit> createProtosUnit() {
        List<Unit> UnitList = new ArrayList<>();
        for (int i = 0; i < this.numberOfProtosUnitsCreated; i++) {
            int num = (int) (Math.random() * this.protosUnit.length);
            UnitList.add(this.protosFactory.createProtosUnit(this.protosUnit[num]));
        }
        return UnitList;
    }

}
