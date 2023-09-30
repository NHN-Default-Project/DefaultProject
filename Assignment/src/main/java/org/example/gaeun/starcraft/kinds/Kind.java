package org.example.gaeun.starcraft.kinds;

import org.example.gaeun.starcraft.Unit;

import java.util.HashMap;
import java.util.Map;

public class Kind {
    private String name;
    public Kind() {
    }
    public Map<String, Unit> getUnits() {
        return new HashMap<>();
    }
    public boolean canFly() {return false;}
    public void printStatus(){

    }
    public int getAttackPow(String ourForce) {
        return 0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int setDefensivePow(String enemyForce, int attackPow) {
        return 0;
    }
    public void removeUnit(String unit){

    }
}
