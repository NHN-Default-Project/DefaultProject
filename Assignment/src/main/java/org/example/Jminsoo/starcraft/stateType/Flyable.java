package org.example.Jminsoo.starcraft.stateType;

public interface Flyable<S extends Unit> extends Unit {
    void attack(S unit);

}
