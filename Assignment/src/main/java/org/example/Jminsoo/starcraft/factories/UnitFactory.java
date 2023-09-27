package org.example.Jminsoo.starcraft.factories;

import org.example.Jminsoo.starcraft.stateType.Unit;

public abstract class UnitFactory {
    public Unit newInstance() {
        Unit unit = createUnit();
        return unit;
    }

    protected abstract Unit createUnit();
}
