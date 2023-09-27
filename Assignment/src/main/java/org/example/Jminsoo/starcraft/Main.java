package org.example.Jminsoo.starcraft;

import org.example.Jminsoo.starcraft.game.UnitCreator;
import org.example.Jminsoo.starcraft.game.gameControl;
import org.example.Jminsoo.starcraft.stateType.Unit;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*TODO 종족 만들기!
         *  */
        UnitCreator unitCreator = new UnitCreator("Terran");
        unitCreator.randomFactory();
        List<Unit> units = unitCreator.getUnits();
        gameControl gameController = gameControl.gameControlBuilder.agameControl()
                .withMyUnits(units)
                .withEnemyUnits(units)
                .withMyRace("Terran")
                .withEnemyRace("Terran")
                .build();

        System.out.println(gameController);

        gameController.attackOrder(0, 1);
        System.out.println(gameController);

    }
}
