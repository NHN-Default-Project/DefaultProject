package org.example.parkminsu.starcraft;

import org.example.parkminsu.starcraft.tribe.Protos;
import org.example.parkminsu.starcraft.tribe.Terran;
import org.example.parkminsu.starcraft.tribe.Zerg;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Player {
    private String tribe;
    private String name;
    private List<Unit> playerUnitList;

    public Player(String tribe, String name) {
        this.tribe = tribe;
        this.name = name;
        this.playerUnitList = new ArrayList<>();
        createUnitOfPlayerTribe();
    }

    public void createUnitOfPlayerTribe() {
        switch (this.tribe) {
            case "terran":
                Terran terran = new Terran();
                this.tribe = "Terran";
                this.playerUnitList = terran.createTerranUnit();
                break;
            case "protos":
                Protos protos = new Protos();
                this.tribe = "Protos";
                this.playerUnitList = protos.createProtosUnit();
                break;
            case "zerg":
                Zerg zerg = new Zerg();
                this.tribe = "Zerg";
                this.playerUnitList = zerg.createZergUnit();
                break;
            default:
                throw new InputMismatchException("잘못된 종족을 입력하셨습니다.");
        }
    }

    public boolean allDeadPlayerUnit() {
        for (int i = 0; i < this.playerUnitList.size(); i++) {
            if (!this.playerUnitList.get(i).dieUnit()) {
                return false;
            }
        }
        return true;
    }

    public void attackEnemyUnit(Player enemy, int attackExcutionUnit, int unitToAttack) {
        this.playerUnitList.get(attackExcutionUnit).attack(enemy.getPlayerUnitList().get(unitToAttack));
    }


    public String getName() {
        return name;
    }

    public String getTribe() {
        return tribe;
    }

    public List<Unit> getPlayerUnitList() {
        return playerUnitList;
    }

}
