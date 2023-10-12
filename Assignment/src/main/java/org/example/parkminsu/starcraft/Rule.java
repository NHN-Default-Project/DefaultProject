package org.example.parkminsu.starcraft;

public class Rule {
    public boolean endGameCondition(Player user, Player computer) {
        if (user.allDeadPlayerUnit() || computer.allDeadPlayerUnit()) {
            return true;
        }
        return false;
    }

    public boolean victoryPlayer(Player user, Player computer) {
        if (user.allDeadPlayerUnit() && !computer.allDeadPlayerUnit()) {
            return false;
        }
        return true;
    }

    public boolean canNotAttackUnit(Player user, Player enemy) {
        for (int i = 0; i < user.getPlayerUnitList().size(); i++) {
            for (int j = 0; j < enemy.getPlayerUnitList().size(); j++) {
                if (user.getPlayerUnitList().get(i).attackable(enemy.getPlayerUnitList().get(j)) && !user.getPlayerUnitList().get(i).dieUnit() && !enemy.getPlayerUnitList().get(j).dieUnit()) {
                    return false;
                }
            }
        }
        return true; // user가 상대를 때릴 만한 유닛이 없을 때
    }
}
