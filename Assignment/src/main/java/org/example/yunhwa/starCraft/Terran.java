package org.example.yunhwa.starCraft;

public interface Terran extends Race { // Marine Tank Goliath Wraith Valkyrie
    Race Terran = new Terran() {
    };
}

//class BattleCruzer extends Unit implements Terran, Flyable {
//    public BattleCruzer() {
//        super(20, 30);
//    }
//}

class Marine extends Unit implements Terran, NotFlyable {
    public Marine() {
        super(3, 10);
    }
}

class Tank extends Unit implements Terran, NotFlyable {
    public Tank() {
        super(7, 15);
    }
}

class Goliath extends Unit implements Terran, NotFlyable {
    public Goliath() {
        super(5, 15);
    }

    @Override
    public boolean canLaunchMissile() {
        return true;
    }

    @Override
    public boolean canAttackFlyable() {
        return true;
    }
}

class Wraith extends Unit implements Terran, Flyable {
    public Wraith() {
        super(3, 10);
    }
}

class Valkyrie extends Unit implements Terran, Flyable {
    public Valkyrie() {
        super(4, 12);
    }
}