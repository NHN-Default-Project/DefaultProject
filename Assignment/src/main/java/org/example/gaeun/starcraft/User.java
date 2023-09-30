package org.example.gaeun.starcraft;

import org.example.gaeun.starcraft.exception.AttackCouldNotException;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class User extends Starcraft {

    public User() {
        super();
    }

    public static void userChoiceUnit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("게임이 시작되었습니다.");
        System.out.println("3가지 종족 중 하나를 선택할 수 있습니다. (1) Terran (2) Protos (3) Zerg");
        while (true) {
            try {
                int choiceNum = scanner.nextInt();
                Starcraft.userKind = choiceUnit(choiceNum);
                Starcraft.userKind.setName("아군");
                break;
            } catch (InputMismatchException ime) {
                System.out.println("1~3중에 선택해주세요.");
            }
        }
    }
    public void attackUser() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                System.out.printf("공격을 수행할 아군 유닛과 공격할 적군 유닛을 선택하세요: ");
                String ourForce = scanner.next();
                String enemyForce = scanner.next();

                if(canAttack(userKind, computerKind, ourForce.toLowerCase(), enemyForce.toLowerCase())) {
                    attack(userKind, computerKind, ourForce.toLowerCase(), enemyForce.toLowerCase());
                    break;
                }
            } catch(NullPointerException e) {
                System.out.println("입력된 유닛을 찾을 수 없습니다. 다시 확인 후 입력해주세요!");
            } catch (AttackCouldNotException acne) {
                System.out.println("날 수 없는 유닛은 날 수 있는 유닛을 공격할 수 없습니다. 다시 입력해주세요.");
            } catch (InterruptedException e) {

            }
        }
//        scanner.close();
    }
}
