package org.example.jaehyeon.tribe;

import org.example.jaehyeon.starcraft.Unit;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Random;

public abstract class Tribe {

    List<Unit> unitList;

    public void addUnit(int unitNumber, String[] unit) {
        for (int i = 0; i < unitNumber; i++) {
            unitList.add(randomProductionUnit(unit));
        }
    }

    public Unit randomProductionUnit(String[] unit) {
        Random random = new Random();
        try {
            String selectUnit = unit[random.nextInt(unit.length)];

            return (Unit) this.getClass().getMethod(selectUnit).invoke(this);

        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }


    public List<Unit> getUnitList() {
        return unitList;
    }
}
