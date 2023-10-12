package org.example.gaeun.starcraft;

import org.example.gaeun.starcraft.exception.AttackCouldNotException;

import java.util.*;

public class Computer extends Starcraft{
    public Computer() {
        super();
    }

    public static void comChoiceUnit() {
        Random random = new Random();
        Starcraft.computerKind = choiceUnit(random.nextInt(3) + 1);
        Starcraft.computerKind.setName("적군");
    }
    public void attackComputer() {
        Random random = new Random();
        while(true) {
            try{
                int ourForce = random.nextInt(computerKind.getUnits().size());
                int enemyForce = random.nextInt(userKind.getUnits().size());

                if(canAttack(computerKind, userKind, ourForce, enemyForce)) {
                    attack(computerKind, userKind, ourForce, enemyForce);
                    break;
                }
                System.out.println(computerKind.getName() + "에서 공격할 수 있는 유닛이 없습니다!");
                break;
            } catch (InputMismatchException | AttackCouldNotException | NullPointerException
                    | InterruptedException | IllegalArgumentException e){
                System.out.println("공격할 수 없어서 다시 시도합니다.");
                Thread.currentThread().interrupt();
            }
        }
    }
}
