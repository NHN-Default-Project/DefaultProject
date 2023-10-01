package org.example.jaehyeon.tribe;


import org.example.jaehyeon.starcraft.terran.*;

public class Terran extends Tribe {

    private static final String[] UNIT = {"marine", "tank", "goliath", "wraith", "valkyrie"};
    int PRODUCTION_NUMBER = 5;

    public Terran() {
        for (int i = 0; i < PRODUCTION_NUMBER; i++) {
            unitList.add(randomProductionUnit(UNIT));
        }
    }

//    public Unit randomProductionUnit() {
//        Random random = new Random();
//        try {
//            String selectUnit = UNIT[random.nextInt(UNIT.length)];
//
//            return (Unit) this.getClass().getMethod(selectUnit).invoke(selectUnit);
//
//        } catch (NoSuchMethodException e) {
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        }
//
//    }


    public Marine marine() {
        return new Marine();
    }

    public Tank tank() {
        return new Tank();
    }

    public Valkyrie valkyrie() {
        return new Valkyrie();
    }

    public Goliath goliath() {
        return new Goliath();
    }

    public Wraith wraith() {
        return new Wraith();
    }
}
