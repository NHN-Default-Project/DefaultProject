package org.example.Jminsoo.starcraft.factories;

import org.example.Jminsoo.starcraft.stateType.Unit;
import org.example.Jminsoo.starcraft.terran.Wraith;

public class WraithFactory extends UnitFactory {
    @Override
    protected Unit createUnit() {
        return new Wraith();
    }
}
