package org.example.Jminsoo.starcraft.stateType;

public interface Walkable<S extends Walkable> extends Unit {
    public void attack(S unit);

}
