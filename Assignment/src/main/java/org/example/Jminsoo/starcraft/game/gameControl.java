package org.example.Jminsoo.starcraft.game;

import org.example.Jminsoo.starcraft.stateType.Unit;

import java.util.List;
import java.util.stream.Collectors;

public class gameControl {
    private List<Unit> enemyUnits;
    private List<Unit> myUnits;

    private String enemyRace;
    private String myRace;


    public void attackOrder(int attackUnitIndex, int hitUnitIndex) {
        Unit attackUnit = myUnits.get(attackUnitIndex);
        Unit hitUnit = enemyUnits.get(hitUnitIndex);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("아군 유닛 %s가 적군 유닛 %s를 공격!%n", ))

        hitUnit.hit(myUnits.get(attackUnitIndex).getAttack());
        dieFilter();
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


    public static final class gameControlBuilder {
        private List<Unit> enemyUnits;
        private List<Unit> myUnits;
        private String enemyRace;
        private String myRace;

        private gameControlBuilder() {
        }

        public static gameControlBuilder agameControl() {
            return new gameControlBuilder();
        }

        public gameControlBuilder withEnemyUnits(List<Unit> enemyUnits) {
            this.enemyUnits = enemyUnits;
            return this;
        }

        public gameControlBuilder withMyUnits(List<Unit> myUnits) {
            this.myUnits = myUnits;
            return this;
        }

        public gameControlBuilder withEnemyRace(String enemyRace) {
            this.enemyRace = enemyRace;
            return this;
        }

        public gameControlBuilder withMyRace(String myRace) {
            this.myRace = myRace;
            return this;
        }

        public gameControl build() {
            gameControl gameControl = new gameControl();
            gameControl.enemyUnits = this.enemyUnits;
            gameControl.myUnits = this.myUnits;
            gameControl.enemyRace = this.enemyRace;
            gameControl.myRace = this.myRace;
            return gameControl;
        }
    }
}
