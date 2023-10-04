package org.example.jaehyeon.tribe;

import org.example.jaehyeon.starcraft.unit.Unit;
import org.example.jaehyeon.starcraft.tribe.Zerg;
import org.junit.jupiter.api.Test;

class ZergTest {

    @Test
    void constructorTest() {
        Zerg zerg = new Zerg();
        for (Unit unit : zerg.getUnitList()) {
            System.out.println(unit.toString());
        }
    }

}