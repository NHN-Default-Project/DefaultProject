package org.example.yunhwa.starcraft.player;

import org.example.yunhwa.starcraft.Race;
import org.example.yunhwa.starcraft.RaceUnitType;
import org.example.yunhwa.starcraft.Unit;

import java.util.List;

public class Player { // Player 만드는 중 (미완성)
    Race race;
    RaceUnitType raceUnitTypes;
    List<Unit> unitList;

    public Player(Race race, RaceUnitType raceUnitTypes, List<Unit> unitList) {
        this.race = race;
        this.raceUnitTypes = raceUnitTypes;
        this.unitList = unitList;
    }

}