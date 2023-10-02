package org.example.gaeun.starcraft;

import org.example.gaeun.starcraft.kinds.Kind;
import org.example.gaeun.starcraft.kinds.Protos;
import org.example.gaeun.starcraft.kinds.Terran;
import org.example.gaeun.starcraft.kinds.Zerg;
import org.example.gaeun.starcraft.exception.AttackCouldNotException;

import java.util.*;

public class Starcraft {
    protected static Kind userKind = new Kind();
    protected static Kind computerKind = new Kind();
    private Judge judge = new Judge();
    private Thread thread = new Thread(judge);
    public Starcraft() {
        thread.start();
    }

    public static Kind choiceUnit(int choiceNum) {
        switch (choiceNum) {
            case 1:
                return new Terran();
            case 2:
                return new Protos();
            case 3:
                return new Zerg();
            default:
                throw new InputMismatchException();
        }

    }
    public void printStatus() {
        userKind.printStatus();
        computerKind.printStatus();
    }

    public void attack(Kind aggressor, Kind defender, int ourForce, int enemyForce) throws InterruptedException {
        int attackPow = aggressor.getAttackPow(ourForce);
        if(defender.setDefensivePow(enemyForce, attackPow) <= 0) {
            defender.removeUnit(enemyForce);
        }
        judge.startRunning();
    }

    public boolean canAttack(Kind aggressor, Kind defender, int ourForce, int enemyForce) throws AttackCouldNotException {
        if(!canAttack(aggressor, defender)) {
            return false;
        }
        if(aggressor.getUnits().get(ourForce).canFly()
            || aggressor.getUnits().get(ourForce).hasItems()) {
            return true;
        }
        if(!defender.getUnits().get(enemyForce).canFly()) {
            return true;
        }
        throw new AttackCouldNotException();
    }
    public boolean canAttack(Kind aggressor, Kind defender) {
        for(Unit unit : aggressor.getUnits()) {
            if(unit.hasItems() || unit.canFly()) {
                return true;
            }
        }
        for(Unit unit : defender.getUnits()) {
            if(!unit.canFly()) {
                return true;
            }
        }
        return false;
    }
}
