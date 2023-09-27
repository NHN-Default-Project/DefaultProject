package org.example.Jminsoo.starcraft.factories;

import org.example.Jminsoo.starcraft.stateType.Unit;
import org.example.Jminsoo.starcraft.terran.Goliath;

public class GoliathFactory extends UnitFactory {
    @Override
    protected Unit createUnit() {
        return new Goliath<>();
    }
}
