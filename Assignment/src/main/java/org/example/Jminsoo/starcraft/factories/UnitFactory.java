package org.example.Jminsoo.starcraft.factories;

import org.example.Jminsoo.starcraft.stateType.Unit;

public abstract class UnitFactory {

    public Unit newInstance(String name) {
        Unit unit = createUnit(name);
        return unit;
    }

    protected abstract Unit createUnit(String name);

    public abstract String[] getUnitNames();


}
