package org.example.gaeun.starcraft.kinds;

import org.example.gaeun.starcraft.protosUnits.*;
import org.example.gaeun.starcraft.Unit;

import java.util.HashMap;
import java.util.Map;

public class Protos extends Kind {
    private String name;

    private Map<String, Unit> units;

    public Protos() {
        units = new HashMap<>();
        units.put("zealot", new Zealot());
        units.put("dragoon", new Dragoon());
        units.put("hightempler", new HighTempler());
        units.put("scout", new Scout());
        units.put("corsair", new Corsair());
        units.put("carrier", new Carrier());
    }

    @Override
    public Map<String, Unit> getUnits() {
        return units;
    }

    @Override
    public void printStatus() {
        System.out.println(getName() + ": Protos");
        int i = 0;
        for (Unit unit : units.values()) {
            System.out.printf("%d. ", i);
            unit.printStatus();
            i = i + 1;
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
