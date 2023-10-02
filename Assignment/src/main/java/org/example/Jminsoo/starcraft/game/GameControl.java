package org.example.Jminsoo.starcraft.game;

import org.example.Jminsoo.starcraft.stateType.Unit;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameControl {
    Scanner scanner;
    String playerRace;
    List<Unit> playerUnits;

    String enemyRace;
    List<Unit> enemyUnits;

    public GameControl() {
        this.scanner = new Scanner(System.in);
    }


    public void makeGame() {

        System.out.println("게임을 시작합니다.");
        System.out.print("종족을 선택해주세요\n(테란 : 0, 저그 : 1, 프로토스 : 2) : ");

        while (true) {
            try {
                setPlayerRace();
            } catch (IllegalArgumentException e) {
                System.out.println("0, 1, 2 중에 골라주세요!");
                continue;
            }
            break;
        }
        setComputerRace();
        System.out.printf("선택된 적군 종족 : %s%n", this.enemyRace);
        createUnits();
        AttackControl gameAttackController = AttackControl.AttackControlBuilder.agameControl()
                .withMyUnits(this.playerUnits)
                .withEnemyUnits(this.enemyUnits)
                .withMyRace(this.playerRace)
                .withEnemyRace(this.enemyRace)
                .build();

        System.out.println(gameAttackController);

        while (true) {
            try {
                System.out.println("플레이어의 차례입니다!\n");

                this.playerAttack(gameAttackController);
                System.out.println("적군 차례입니다!\n");
                this.enemyAttack(gameAttackController);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
        }

    }

    private void playerAttack(AttackControl gameAttackController) {
        int playerUnitIndex;
        int enemyUnitIndex;

        System.out.print("공격을 수행할 아군 유닛과 적군 유닛을 선택하세요 : ");

        try {
            playerUnitIndex = scanner.nextInt();
            enemyUnitIndex = scanner.nextInt();

            if (isIllegalChoose(playerUnitIndex, enemyUnitIndex)) {
                throw new IllegalArgumentException("유닛을 제대로 선택해주세요!");
            }

        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("입력 타입이 다릅니다!");
        }

        gameAttackController.attackOrder(playerUnitIndex, enemyUnitIndex, false);
        System.out.println(gameAttackController);
    }

    private void enemyAttack(AttackControl gameAttackController) {
        int playerUnitIndex = new Random().nextInt(this.playerUnits.size());
        int enemyUnitIndex = new Random().nextInt(this.enemyUnits.size());

        gameAttackController.attackOrder(playerUnitIndex, enemyUnitIndex, true);
        System.out.println(gameAttackController);
    }

    public boolean isIllegalChoose(int playerChooseIndex, int enemyChooseIndex) {
        if (playerChooseIndex > this.playerUnits.size() - 1 || enemyChooseIndex > this.enemyUnits.size() - 1 || playerChooseIndex < 0 || enemyChooseIndex < 0) {
            return true;
        } else {
            return false;
        }
    }

    private void createUnits() {
        System.out.println("유닛을 생성합니다.");
        this.playerUnits = new UnitCreator(this.playerRace).randomFactory().getUnits();
        this.enemyUnits = new UnitCreator(this.enemyRace).randomFactory().getUnits();
    }

    private String chooseRace(int number) {
        switch (number) {
            case 0:
                return "Terran";
            case 1:
                return "Zerg";
            case 2:
                return "Protos";
            default:
                throw new IllegalArgumentException();
        }
    }

    private void setComputerRace() {
        int computerNum = 0;
        this.enemyRace = chooseRace(computerNum);
    }


    public void setPlayerRace() {
        try {
            int playerRace = scanner.nextInt();
            this.playerRace = chooseRace(playerRace);
        } catch (InputMismatchException | IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
