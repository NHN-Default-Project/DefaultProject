package org.example.parkminsu.starcraft;

public interface Attack {
    boolean attackable(Unit unit);

    void attack(Unit unit);
}
