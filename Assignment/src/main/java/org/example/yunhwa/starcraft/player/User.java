package org.example.yunhwa.starcraft.player;

import org.example.yunhwa.starcraft.Race;
import org.example.yunhwa.starcraft.RaceUnitType;
import org.example.yunhwa.starcraft.Unit;
import org.example.yunhwa.starcraft.player.Player;

import java.util.List;

public class User extends Player { // User 만드는 중 (미완성)
    Race userRace;
    RaceUnitType userRaceUnitTypes;
    List<Unit> userUnitList;

    public User(Race userRace, RaceUnitType userRaceUnitTypes, List<Unit> userUnitList) {
        super(userRace, userRaceUnitTypes, userUnitList);
    }

}