package org.example.parkminsu.starcraft;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game extends Rule {
    private Player user;
    private Player computer;

    public Game() {
    }

    public void gameProgress() {
        Scanner scanner = new Scanner(System.in);
        this.user = chooseSelectedTribe(scanner, "아군"); // 종족 선택
        this.computer = chooseRandomTribe("적군");// 컴퓨터 종족 선택

        printPlayersUnit();
        // 여기까지 종족 선택 및 종족 관련 유닛 생성

        while (true) {
            try {
                if (canNotAttackUnit(this.user, this.computer)) {
                    System.out.println("때릴 수 있는 유닛이 없음");
                    System.out.println("컴퓨터 승리");
                    break;
                }
                userTurn(this.user, this.computer);
                if (endGameCondition(this.user, this.computer)) {
                    if (victoryPlayer(this.user, this.computer)) {
                        System.out.println("유저 승");
                    }
                    break;
                }
                // computer turn
                if (canNotAttackUnit(this.computer, this.user)) {
                    System.out.println("때릴 수 있는 유닛이 없음");
                    System.out.println("유저 승");
                    break;
                }
                computerTurn(this.computer, this.user);

                if (endGameCondition(this.user, this.computer)) {
                    if (victoryPlayer(this.computer, this.user)) {
                        System.out.println("컴퓨터 승");
                    }
                    break;
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("입력하신 유닛은 없습니다.");
            } catch (InputMismatchException e) {
                System.out.println("유닛을 잘못 입력하셨습니다");
            }
        }
        scanner.close();
    }

    public Player chooseSelectedTribe(Scanner scanner, String name) {
        System.out.println("종족을 선택하세요(Terran, Protos, Zerg)");
        String tribe = scanner.nextLine().trim().toLowerCase();
        return new Player(tribe, name);
    }

    public Player chooseRandomTribe(String name) {
        System.out.println("컴퓨터가 종족을 선택했습니다.");
        int tribe = (int) (Math.random() * 3);
        switch (tribe) {
            case 0:
                return new Player("terran", name);
            case 1:
                return new Player("protos", name);
            case 2:
                return new Player("zerg", name);
            default:
                throw new InputMismatchException("알맞지 않은 종족의 값이 나왔습니다.");
        }
    }

    public void playerTurn(Player friendlyPlayer, Player enemyPlayer, int attackExcutionUnit, int unitToAttack) {
        friendlyPlayer.attackEnemyUnit(enemyPlayer, attackExcutionUnit, unitToAttack);
        printPlayersUnit();
    }

    public void userTurn(Player user, Player computer) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("공격을 수행할 아군 유닛과 공격할 적군 유닛 정하시오");
                int num = scanner.nextInt();
                int num1 = scanner.nextInt();
                playerTurn(user, computer, num, num1);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    public void computerTurn(Player computer, Player user) {
        while (true) {
            try {
                playerTurn(computer, user, (int) (Math.random() * computer.getPlayerUnitList().size()), (int) (Math.random() * user.getPlayerUnitList().size()));
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printPlayersUnit() {
        printUnit(this.user);
        printUnit(this.computer);
    }

    public void printUnit(Player player) {
        System.out.println(player.getName() + ": " + player.getTribe());
        for (int i = 0; i < player.getPlayerUnitList().size(); i++) {
            if (!player.getPlayerUnitList().get(i).dieUnit()) {
                System.out.println(i + ". " + player.getPlayerUnitList().get(i).toString());
            }
        }
        System.out.println();
    }

}
