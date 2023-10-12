package org.example.Jminsoo.starcraft.game;

import org.example.Jminsoo.starcraft.unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private String race;
    private List<Unit> units;

    public Player() {
        units = new ArrayList<>();
    }


    public void setRace(String race) {
        this.race = race;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }


    public List<Unit> getUnits() {
        return units;
    }

    public String getRace() {
        return race;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.getUnits().size(); i++) {
            sb.append(String.format("%d. %s%n", i, this.getUnits().get(i)));
        }
        return sb.toString();
    }


}
