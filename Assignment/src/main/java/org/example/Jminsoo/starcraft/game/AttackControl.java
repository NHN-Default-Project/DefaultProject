package org.example.Jminsoo.starcraft.game;

import org.example.Jminsoo.starcraft.unit.Unit;

import java.util.stream.Collectors;

public class AttackControl {
    Player player;
    Player computer;

    public void attackOrder(Player player1, Player player2, int attackUnitIndex, int hitUnitIndex, boolean isComputer) {

        Unit attackUnit;
        Unit hitUnit;
        try {
            if (isComputer) {
                attackUnit = player2.getUnits().get(attackUnitIndex);
                hitUnit = player1.getUnits().get(hitUnitIndex);
            } else {
                attackUnit = player1.getUnits().get(attackUnitIndex);
                hitUnit = player2.getUnits().get(hitUnitIndex);
            }

        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            throw new IndexOutOfBoundsException("공격 유닛을 다시 지정해주세요!");
        }

        try {
            attackUnit.attack(hitUnit);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        System.out.println(String.format("유닛 %s, 유닛 %s를 공격!%n", attackUnit.getName(), hitUnit.getName()));
        this.dieFilter(player1, player2);
    }

    public void dieFilter(Player player1, Player player2) {
        player1.setUnits(player1.getUnits().stream()
                .filter(x -> !x.isDie())
                .collect(Collectors.toList()));

        player2.setUnits(player2.getUnits().stream()
                .filter(x -> !x.isDie())
                .collect(Collectors.toList()));
    }

}
