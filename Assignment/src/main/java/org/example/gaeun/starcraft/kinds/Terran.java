package org.example.gaeun.starcraft.kinds;

import org.example.gaeun.starcraft.terranUnits.*;
import org.example.gaeun.starcraft.Unit;

import java.util.HashMap;
import java.util.Map;

public class Terran extends Kind {
    private String name;

    private Map<String, Unit> units;

    public Terran() {
        units = new HashMap<>();
        units.put("marine", new Marine());
        units.put("tank", new Tank());
        units.put("goliath", new Goliath());
        units.put("wraith", new Wraith());
        units.put("valkyrie", new Valkyrie());
        units.put("battlecruzer", new BattleCruzer());
    }
    @Override
    public Map<String, Unit> getUnits() {
        return units;
    }

    @Override
    public void printStatus() {
        System.out.println(getName() + ": Terran");
        int i = 0;
        for (Unit unit : units.values()) {
            System.out.printf("%d. ", i++);
            unit.printStatus();
        }
        System.out.println();
    }

    @Override
    public int getAttackPow(String ourForce) {
        return units.get(ourForce).getAttackPow();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int setDefensivePow(String enemyForce, int attackPow) {
        return units.get(enemyForce).setDefensivePow(attackPow);
    }
    @Override
    public void removeUnit(String unit) {
        units.remove(unit);
    }

}
