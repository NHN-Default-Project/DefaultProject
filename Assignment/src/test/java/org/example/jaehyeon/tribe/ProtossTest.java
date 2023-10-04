package org.example.jaehyeon.tribe;

import org.example.jaehyeon.starcraft.unit.Unit;
import org.example.jaehyeon.starcraft.tribe.Protoss;
import org.junit.jupiter.api.Test;

class ProtossTest {

    @Test
    void constructorTest() {
        Protoss protoss = new Protoss();
        for (Unit unit : protoss.getUnitList()) {
            System.out.println(unit.toString());
        }
    }

//    @Test
//    void test() {
//        Protoss protoss = new Protoss();
//        System.out.println(protoss.corsair().canFly() + " " + protoss.corsair().getHasItem());
//        System.out.println(protoss.dragoon().canFly() + " " + protoss.dragoon().getHasItem());
//        System.out.println(protoss.highTempler().canFly() + " " + protoss.highTempler().getHasItem());
//        System.out.println(protoss.scout().canFly() + " " + protoss.scout().getHasItem());
//        System.out.println(protoss.zealot().canFly() + " " + protoss.zealot().getHasItem());
//    }

}