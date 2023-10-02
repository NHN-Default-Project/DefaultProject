package org.example.gaeun.starcraft.kinds;

import org.example.gaeun.starcraft.Unit;
import org.example.gaeun.starcraft.terranUnits.*;
import org.example.gaeun.starcraft.zergUnits.*;


import java.util.*;

public class Zerg extends Kind {
    private String name;
    private List<Unit> units;
    private int UNIT_NUM = 8;
    private int TOTAL_UNIT_NUM = 6;

    public Zerg() {
        units = new ArrayList<>(UNIT_NUM);
        putUnit(UNIT_NUM);
    }

    public void putUnit(int num) {
        Random random = new Random();
        for(int i = 0; i < num; i++) {
            int randNum = random.nextInt(TOTAL_UNIT_NUM) + 1;
            units.add(randomUnit(randNum));
        }
    }

    public Unit randomUnit(int num) {
        switch (num) {
            case 1:
                return new Zergling();
            case 2:
                return new Hydralisk();
            case 3:
                return new Ultralisk();
            case 4:
                return new Mutalisk();
            case 5:
                return new Guardian();
            case 6:
                return new Queen();
            default:
                return new Zergling();
        }
    }

    @Override
    public List<Unit> getUnits() {
        return units;
    }
    @Override
    public void printStatus() {
        System.out.println(getName() + ": Zerg");
        int i = 0;
        for (Unit unit : units) {
            System.out.printf("%d. ", i++);
            unit.printStatus();
        }
        System.out.println();
    }

    @Override
    public int getAttackPow(int ourForce) {
        return units.get(ourForce).getAttackPow();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int setDefensivePow(int enemyForce, int attackPow) {
        return units.get(enemyForce).setDefensivePow(attackPow);
    }
    @Override
    public void removeUnit(int unit) {
        units.remove(unit);
    }

}
