package com.nhnacademy.yunhwa.Exercise4_3;

import java.util.ArrayList;
import java.util.List;

public class RollDices { // 주사위를 돌리자
    private List<Dice> dices; // 돌릴 주사위들이 필요해

    public RollDices(int dicesCount, int totalEyesNum) { // 주사위 개수만큼 돌릴래
        dices = new ArrayList<Dice>(dicesCount);

        for (int i = 0; i < dicesCount; i++) {
            dices.add(new Dice(totalEyesNum));
        }
    }

    public List<Dice> getDices() { // 주사위들의 정보를 얻어오자
        return dices;
    }

    public void rollAPairOfDice(int totalEyesNum) { // totalEyesNum 면체 주사위 한 쌍(2개) 를 돌리자
        rollManyDice(2, totalEyesNum);
    }

    // 주사위들 돌리는 작업 메서드 (마치 setter 같음): 무조건 여기는 거쳐야 함. 돌릴 주사위를 한 번 돌려야지 현재 눈이 결정되기 때문.
    public void rollManyDice(int dicesCount, int totalEyesNum) { // totalEyesNum 면체 주사위 여러 개를 돌리자

        for (int i = 0; i < dices.size(); i++) {
            dices.get(i).rollDice(); // 각각의 현재 눈이 결정됨.
        }
    }
}
