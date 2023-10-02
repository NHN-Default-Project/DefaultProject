package org.example.Jminsoo.starcraft;

import org.example.Jminsoo.starcraft.game.GameControl;

public class Main {
    public static void main(String[] args) {
        /*TODO 종족 만들기!
         *  */

        GameControl gameControl = new GameControl();
        gameControl.makeGame();
//        UnitCreator playerUnitCreator = new UnitCreator("Terran");
//        UnitCreator enemnyUnitCreator = new UnitCreator("Terran");
//
//        playerUnitCreator.randomFactory();
//        enemnyUnitCreator.randomFactory();
//        List<Unit> playerUnits = playerUnitCreator.getUnits();
//
//        List<Unit> enemyUnits = enemnyUnitCreator.getUnits();
//
//        AttackControl gameAttackController = AttackControl.AttackControlBuilder.agameControl()
//                .withMyUnits(playerUnits)
//                .withEnemyUnits(enemyUnits)
//                .withMyRace("Terran")
//                .withEnemyRace("Terran")
//                .build();
//
//        System.out.println(gameAttackController);
//
//
//        for (int i = 0; i < 3; i++) {
//            gameAttackController.attackOrder(0, 1);
//            System.out.println(gameAttackController);
//        }

    }
}
