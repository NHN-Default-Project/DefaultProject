package org.example.Jminsoo.starcraft.factories;

import org.example.Jminsoo.starcraft.stateType.Unit;
import org.example.Jminsoo.starcraft.terran.Marine;

public class MarineFactory extends UnitFactory {
    @Override
    protected Unit createUnit() {
        return new Marine<>();
    }
}
