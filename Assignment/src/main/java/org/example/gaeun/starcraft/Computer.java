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
                List<String> keyList = new ArrayList<>(computerKind.getUnits().keySet());
                String ourForce = keyList.get(random.nextInt(keyList.size()));
                keyList = new ArrayList<>(userKind.getUnits().keySet());
                String enemyForce = keyList.get(random.nextInt(keyList.size()));
                System.out.println(ourForce + " " + enemyForce);

                if(canAttack(computerKind, userKind, ourForce.toLowerCase(), enemyForce.toLowerCase())) {
                    attack(computerKind, userKind, ourForce.toLowerCase(), enemyForce.toLowerCase());
                    break;
                }
            } catch (InputMismatchException | AttackCouldNotException | NullPointerException e){

            } catch (InterruptedException e) {
            }
        }
    }
}
