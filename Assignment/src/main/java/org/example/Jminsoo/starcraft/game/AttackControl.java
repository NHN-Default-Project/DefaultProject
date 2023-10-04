package org.example.Jminsoo.starcraft.game;

import org.example.Jminsoo.starcraft.unit.Unit;

import java.util.stream.Collectors;

public class AttackControl {
    Player player;
    Player computer;

    public void attackOrder(int attackUnitIndex, int hitUnitIndex, boolean isComputer) {

        Unit attackUnit = null;
        Unit hitUnit = null;
        while (true) {
            try {
                if (isComputer) {
                    attackUnit = this.computer.getUnits().get(attackUnitIndex);
                    hitUnit = this.player.getUnits().get(hitUnitIndex);
                } else {
                    attackUnit = this.player.getUnits().get(attackUnitIndex);
                    hitUnit = this.computer.getUnits().get(hitUnitIndex);
                }

            } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
                throw new IndexOutOfBoundsException("공격 유닛을 다시 지정해주세요!");
            }
            break;
        }


        try {
            attackUnit.attack(hitUnit);
            System.out.println(String.format("유닛 %s, 유닛 %s를 공격!%n", attackUnit.getName(), hitUnit.getName()));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        dieFilter();
    }

    public void dieFilter() {
        player.setUnits(player.getUnits().stream()
                .filter(x -> !x.isDie())
                .collect(Collectors.toList()));

        computer.setUnits(computer.getUnits().stream()
                .filter(x -> !x.isDie())
                .collect(Collectors.toList()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("적군 : %s%n", this.computer.getRace()));
        for (int i = 0; i < computer.getUnits().size(); i++) {
            sb.append(String.format("%d. %s%n", i, computer.getUnits().get(i)));
        }
        sb.append(String.format("%n아군 : %s%n", this.player.getRace()));
        for (int i = 0; i < player.getUnits().size(); i++) {
            sb.append(String.format("%d. %s%n", i, player.getUnits().get(i)));
        }
        return sb.toString();
    }


    public static final class AttackControlBuilder {
        Player player;
        Player computer;

        private AttackControlBuilder() {
        }

        public static AttackControlBuilder agameControl() {
            return new AttackControlBuilder();
        }

        public AttackControlBuilder withPlayer(Player player) {
            this.player = player;
            return this;
        }

        public AttackControlBuilder withComputer(Player computer) {
            this.computer = computer;
            return this;
        }

        public AttackControl build() {
            AttackControl gameAttackControl = new AttackControl();
            gameAttackControl.player = this.player;
            gameAttackControl.computer = this.computer;
            return gameAttackControl;
        }
    }
}
