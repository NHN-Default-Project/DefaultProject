package org.example.Jminsoo.starcraft.game;

import org.example.Jminsoo.starcraft.stateType.Unit;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameControl {
    Player player;
    Player computer;
    Scanner scanner;

    Random random;

    public GameControl() {
        this.scanner = new Scanner(System.in);
        this.player = new Player();
        this.computer = new Player();
        this.random = new Random();
    }


    public void makeGame() {
        System.out.println("게임을 시작합니다.");
        System.out.print("종족을 선택해주세요\n(테란 : 0, 저그 : 1, 프로토스 : 2) : ");

        while (true) {
            try {
                setPlayerRace();
                setComputerRace();
            } catch (IllegalArgumentException e) {
                System.out.println("0, 1, 2 중에 골라주세요!");
                scanner = new Scanner(System.in);
                continue;
            }
            break;
        }
        System.out.printf("선택된 적군 종족 : %s%n", this.computer.getRace());
        createUnits();
        AttackControl gameAttackController = AttackControl.AttackControlBuilder.agameControl()
                .withPlayer(this.player)
                .withComputer(this.computer)
                .build();

        System.out.println(gameAttackController);

        while (true) {
            try {
                if (this.victoryCheck()) {
                    System.out.println("승리했습니다!!");
                    break;
                } else if (this.defeatCheck()) {
                    System.out.println("패배했습니다...");
                    break;
                }

                System.out.println("플레이어의 차례입니다!\n");
                this.playerAttack(gameAttackController);

                if (this.victoryCheck()) {
                    System.out.println("승리했습니다!!");
                    break;
                } else if (this.defeatCheck()) {
                    System.out.println("패배했습니다...");
                    break;
                }

                System.out.println("적군 차례입니다!\n");
                this.enemyAttack(gameAttackController);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                scanner = new Scanner(System.in);
            }
        }
    }

    private boolean victoryCheck() {

        if (this.computer.getUnits().isEmpty()) {
            return true;
        }
        if (this.computerCantAttackFlyable()) {
            System.out.println("특수 승리! : 적이 아군 공중 유닛을 공격할 수 없습니다.");
            return true;
        } else {
            return false;
        }
    }

    private boolean defeatCheck() {

        if (this.player.getUnits().isEmpty()) {
            return true;
        }
        if (this.playerCantAttackFlyable()) {
            System.out.println("특수 패배! : 적 공중 유닛을 공격할 수 없습니다.");
            return true;
        } else return false;
    }

    private boolean computerCantAttackFlyable() {
        boolean isPlayerUnitCanFly = false;
        boolean isComputerUnitCanAttack = false;

        for (Unit playerUnit : this.player.getUnits()) {
            if (playerUnit.getFlyable()) {
                isPlayerUnitCanFly = true;
                break;
            }
        }
        for (Unit computerUnit : this.computer.getUnits()) {
            if (computerUnit.getCanAttackFlyable()) {
                isComputerUnitCanAttack = true;
                break;
            }
        }

        return isPlayerUnitCanFly && !isComputerUnitCanAttack;
    }

    private boolean playerCantAttackFlyable() {
        boolean isPlayerUnitCanAttackFly = false;
        boolean isComputerUnitCanFly = false;

        for (Unit playerUnit : this.player.getUnits()) {
            if (playerUnit.getCanAttackFlyable()) {
                isPlayerUnitCanAttackFly = true;
                break;
            }
        }
        for (Unit computerUnit : this.computer.getUnits()) {
            if (computerUnit.getFlyable()) {
                isComputerUnitCanFly = true;
                break;
            }
        }

        return !isPlayerUnitCanAttackFly && isComputerUnitCanFly;
    }

    private void playerAttack(AttackControl gameAttackController) {
        int playerUnitIndex;
        int enemyUnitIndex;

        System.out.print("공격을 수행할 아군 유닛과 적군 유닛을 선택하세요 : ");

        try {
            playerUnitIndex = scanner.nextInt();
            enemyUnitIndex = scanner.nextInt();

            gameAttackController.attackOrder(playerUnitIndex, enemyUnitIndex, false);


        } catch (InputMismatchException e) {
            scanner = new Scanner(System.in);
            throw new IllegalArgumentException("입력 타입이 다릅니다!");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("공중 유닛을 공격할 수 없습니다!");
        } catch (IndexOutOfBoundsException e) {
            scanner = new Scanner(System.in);
            throw new IllegalArgumentException("범위 내의 유닛만 지정해주세요!");
        }

        System.out.println(gameAttackController);
    }

    private void enemyAttack(AttackControl gameAttackController) {
        while (true) {
            try {
                int playerUnitIndex = random.nextInt(this.player.getUnits().size());
                int enemyUnitIndex = random.nextInt(this.computer.getUnits().size());
                gameAttackController.attackOrder(playerUnitIndex, enemyUnitIndex, true);
            } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
                continue;
            }
            break;
        }

        System.out.println(gameAttackController);
    }

    private void createUnits() {
        System.out.println("유닛을 생성합니다.");
        this.player.setUnits(new UnitCreator(this.player.getRace()).randomFactory().getUnits());
        this.computer.setUnits(new UnitCreator(this.computer.getRace()).randomFactory().getUnits());
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
        int computerNum = random.nextInt(3);
        this.computer.setRace(chooseRace(computerNum));
    }


    public void setPlayerRace() {
        try {
            int playerRace = scanner.nextInt();
            this.player.setRace(chooseRace(playerRace));
        } catch (InputMismatchException | IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}
