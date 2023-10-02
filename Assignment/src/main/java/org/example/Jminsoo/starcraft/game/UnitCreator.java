package org.example.Jminsoo.starcraft.game;

import org.example.Jminsoo.starcraft.factories.GoliathFactory;
import org.example.Jminsoo.starcraft.factories.MarineFactory;
import org.example.Jminsoo.starcraft.factories.UnitFactory;
import org.example.Jminsoo.starcraft.factories.WraithFactory;
import org.example.Jminsoo.starcraft.stateType.Unit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UnitCreator {
    private final static int TERRAN_UNIT_COUNT = 3;
    private List<Unit> units;
    private String race;

    private Random random;


    public UnitCreator(String race) {
        this.units = new ArrayList<>();
        this.random = new Random();
        this.race = race;
    }

    public List<Unit> getUnits() {
        return this.units;
    }

    public UnitCreator randomFactory() {

        int randNum;
        UnitFactory factory;

        if (this.race.equals("Terran")) {
            for (int i = 0; i < TERRAN_UNIT_COUNT; i++) {
                randNum = random.nextInt(TERRAN_UNIT_COUNT);
                if (randNum == 0) {
                    factory = new MarineFactory();
                } else if (randNum == 1) {
                    factory = new GoliathFactory();
                } else if (randNum == 2) {
                    factory = new WraithFactory();
                } else {
                    throw new IllegalArgumentException("randomFactory 오류!");
                }
                addUnits(factory);
            }
        } else if (this.race.equals("Zerg")) {

        } else if (this.race.equals("Protos")) {

        } else {

        }
        return this;

    }

    public void addUnits(UnitFactory factory) {
        this.units.add(factory.newInstance());
    }
}
