package org.example.Jminsoo.starcraft.game;

import org.example.Jminsoo.starcraft.stateType.Unit;

import java.util.List;
import java.util.stream.Collectors;

public class AttackControl {
    private List<Unit> enemyUnits;
    private List<Unit> myUnits;

    private String enemyRace;
    private String myRace;


    public void attackOrder(int attackUnitIndex, int hitUnitIndex, boolean isComputer) {

        Unit attackUnit = null;
        Unit hitUnit = null;
        while (true) {
            try {
                if (isComputer) {
                    attackUnit = enemyUnits.get(attackUnitIndex);
                    hitUnit = myUnits.get(hitUnitIndex);
                } else {
                    attackUnit = myUnits.get(attackUnitIndex);
                    hitUnit = enemyUnits.get(hitUnitIndex);
                }

            } catch (IndexOutOfBoundsException e) {
                System.out.println("공격 유닛을 다시 지정해주세요!");
                continue;
            }
            break;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("유닛 %s가 유닛 %s를 공격!%n", attackUnit.getName(), hitUnit.getName()));
        System.out.println(sb.toString());
        attackUnit.attack(hitUnit);
//        hitUnit.hit(myUnits.get(attackUnitIndex).getAttack());
        dieFilter();
    }

    private void isCanAttack(Unit attackUnit, Unit hitUnit) {

    }

    public void dieFilter() {
        this.myUnits = this.myUnits.stream()
                .filter(x -> !x.isDie())
                .collect(Collectors.toList());

        this.enemyUnits = this.enemyUnits.stream()
                .filter(x -> !x.isDie())
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("적군 : %s%n", this.enemyRace));
        for (int i = 0; i < enemyUnits.size(); i++) {
            sb.append(String.format("%d. %s%n", i, enemyUnits.get(i)));
        }
        sb.append(String.format("%n아군 : %s%n", this.myRace));
        for (int i = 0; i < myUnits.size(); i++) {
            sb.append(String.format("%d. %s%n", i, myUnits.get(i)));
        }
        return sb.toString();
    }


    public static final class AttackControlBuilder {
        private List<Unit> enemyUnits;
        private List<Unit> myUnits;
        private String enemyRace;
        private String myRace;

        private AttackControlBuilder() {
        }

        public static AttackControlBuilder agameControl() {
            return new AttackControlBuilder();
        }

        public AttackControlBuilder withEnemyUnits(List<Unit> enemyUnits) {
            this.enemyUnits = enemyUnits;
            return this;
        }

        public AttackControlBuilder withMyUnits(List<Unit> myUnits) {
            this.myUnits = myUnits;
            return this;
        }

        public AttackControlBuilder withEnemyRace(String enemyRace) {
            this.enemyRace = enemyRace;
            return this;
        }

        public AttackControlBuilder withMyRace(String myRace) {
            this.myRace = myRace;
            return this;
        }

        public AttackControl build() {
            AttackControl gameAttackControl = new AttackControl();
            gameAttackControl.enemyUnits = this.enemyUnits;
            gameAttackControl.myUnits = this.myUnits;
            gameAttackControl.enemyRace = this.enemyRace;
            gameAttackControl.myRace = this.myRace;
            return gameAttackControl;
        }
    }
}
