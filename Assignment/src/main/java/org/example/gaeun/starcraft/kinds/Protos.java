package org.example.gaeun.starcraft.kinds;

import org.example.gaeun.starcraft.protosUnits.*;
import org.example.gaeun.starcraft.Unit;
import org.example.gaeun.starcraft.terranUnits.*;

import java.util.*;

public class Protos extends Kind {
    private String name;

    private List<Unit> units;
    private int UNIT_NUM = 4;
    private int TOTAL_UNIT_NUM = 6;

    public Protos() {
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
                return new Zealot();
            case 2:
                return new Dragoon();
            case 3:
                return new HighTempler();
            case 4:
                return new Scout();
            case 5:
                return new Corsair();
            case 6:
                return new Carrier();
            default:
                return new Zealot();
        }
    }

    @Override
    public List<Unit> getUnits() {
        return units;
    }

    @Override
    public void printStatus() {
        System.out.println(getName() + ": Protos");
        int i = 0;
        for (Unit unit : units) {
            System.out.printf("%d. ", i);
            unit.printStatus();
            i = i + 1;
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
