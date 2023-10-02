package org.example.Jminsoo.starcraft.stateType;

public interface Unit {

    boolean isDie();

    void hit(int attack);

    void attack(Unit unit);

    int getAttack();

    int getDefense();

    String getName();
}
