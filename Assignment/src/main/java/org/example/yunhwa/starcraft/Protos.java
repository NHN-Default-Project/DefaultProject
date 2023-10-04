package org.example.yunhwa.starCraft;

public interface Protos extends Race {
    Race Protos = new Protos() {
    };

}

class Carrier extends Unit implements Protos, Flyable {
    public Carrier() {
        super(25, 40);
    }
}

class Zealot extends Unit implements Protos, NotFlyable {
    public Zealot() {
        super(5, 20);
    }
}

class Dragoon extends Unit implements Protos, NotFlyable {
    public Dragoon() {
        super(3, 15);
    }

    @Override
    public boolean canFireLaser() {
        return true;
    }

    @Override
    public boolean canAttackFlyable() {
        return true;
    }
}

class HighTempler extends Unit implements Protos, NotFlyable {
    public HighTempler() {
        super(10, 2);
    }
}

class Scout extends Unit implements Protos, Flyable {
    public Scout() {
        super(5, 10);
    }
}

class Corsair extends Unit implements Protos, Flyable {
    public Corsair() {
        super(4, 12);
    }
}


