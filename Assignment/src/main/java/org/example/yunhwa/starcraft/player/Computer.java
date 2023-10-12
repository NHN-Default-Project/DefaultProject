package org.example.yunhwa.starcraft.player;

import org.example.yunhwa.starcraft.Race;
import org.example.yunhwa.starcraft.RaceUnitType;
import org.example.yunhwa.starcraft.Unit;
import org.example.yunhwa.starcraft.player.Player;

import java.util.List;

public class Computer extends Player { // Computer 만드는 중 (미완성)
    Race computerRace;
    RaceUnitType computerRaceUnitTypes;
    List<Unit> computerUnitList;

    public Computer(Race computerRace, RaceUnitType computerRaceUnitTypes, List<Unit> computerUnitList) {
        super(computerRace, computerRaceUnitTypes, computerUnitList);
    }

}