package org.example.yunhwa.starcraft;

public interface Zerg extends Race {
    Race Zerg = new Zerg() {
    };
}

class Queen extends Unit implements Zerg, Flyable {
    public Queen() {
        super(15, 25);
    }
}

class Zergling extends Unit implements Zerg, NotFlyable {
    public Zergling() {
        super(2, 2);
    }
}

class Hydralisk extends Unit implements Zerg, NotFlyable {
    public Hydralisk() {
        super(3, 7);
    }

    @Override
    public boolean canShootNeedle() {
        return true;
    }

    @Override
    public boolean canAttackFlyable() {
        return true;
    }
}

class Ultralisk extends Unit implements Zerg, NotFlyable {
    public Ultralisk() {
        super(5, 15);
    }
}

class Mutalisk extends Unit implements Zerg, Flyable {
    public Mutalisk() {
        super(2, 8);
    }
}

class Guardian extends Unit implements Zerg, Flyable {
    public Guardian() {
        super(3, 6);
    }
}