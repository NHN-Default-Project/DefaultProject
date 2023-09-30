package org.example.gaeun.starcraft.kinds;

import org.example.gaeun.starcraft.Unit;
import org.example.gaeun.starcraft.zergUnits.*;

import java.util.HashMap;
import java.util.Map;

public class Zerg extends Kind {
    private String name;
    private Map<String, Unit> units;

    public Zerg() {
        units = new HashMap<>();
        units.put("zergling", new Zergling());
        units.put("hydralisk", new Hydralisk());
        units.put("ultralisk", new Ultralisk());
        units.put("mutalisk", new Mutalisk());
        units.put("guardian", new Guardian());
        units.put("queen", new Queen());
    }
    @Override
    public Map<String, Unit> getUnits() {
        return units;
    }
    @Override
    public void printStatus() {
        System.out.println(getName() + ": Zerg");
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
