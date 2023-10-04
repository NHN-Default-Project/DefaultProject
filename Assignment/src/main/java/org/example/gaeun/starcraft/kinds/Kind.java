package org.example.gaeun.starcraft.kinds;

import org.example.gaeun.starcraft.Unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kind {
    private String name;
    public Kind() {
    }
    public List<Unit> getUnits() {
        return new ArrayList<>();
    }
    public boolean canFly() {
        return false;
    }
    public void printStatus(){

    }
    public int getAttackPow(int ourForce) {
        return 0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int setDefensivePow(int enemyForce, int attackPow) {
        return 0;
    }
    public void removeUnit(int unit){

    }
}
