package com.nhnacademy.yunhwa.Exercise5_5;

import com.nhnacademy.yunhwa.Exercise5_4.Card;
import com.nhnacademy.yunhwa.Exercise5_4.Deck;
import com.nhnacademy.yunhwa.Exercise5_4.Hand;
import com.nhnacademy.yunhwa.Exercise5_4.BlackjackHand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercise5_5 {

    // 사용자가 블랙잭을 플레이할 수 있는 프로그램 작성
    // 카지노에서 진행되는 블랙잭의 단순화된 버전
    // 컴퓨터가 딜러 역할을 함.
    // 프로그램에는 이전에 사용된 Card, Deck, Hand, BlackjackHand 클래스가 필요함.
    
    // 1. 먼저 사용자가 한 게임을 플레이하는 메서드를 작성하기
    //      사용자가 게임에서 승리했는지 여부를 나타내는 boolean 값을 리턴
    //      사용자가 이기면 true, 딜러(컴퓨터)가 이기면 false 리턴

    // 2. 프로그램에는 Deck Object 와 BlackjackHand Object 2개가 필요.
    //      하나는 딜러(컴퓨터)용, 다른 하나는 사용자용
    
    // 3. 블랙잭의 일반적인 목표는 손에 있는 카드들의 값들이 최대한 21에 가까우면서도 초과하지 않도록 만드는 것
    
    // 게임 진행 방식

    // 먼저 각 플레이어의 손에 두 장의 카드가 분배됩니다.
    // 이 시점에서 딜러의 패값이 21이면 딜러가 승리
    // 그렇지 않고 사용자가 21개를 가지고 있으면 사용자 승리 (블랙잭)
    // 딜러와 사용자가 동점일 경우 딜러가 승리
    // 딜러와 사용자 모두 블랙잭을 가지고 있다면 딜러가 승리

    // 게임이 종료되지 않은 경우, 사용자는 자신의 손에 몇 장의 카드를 추가할 수 있는 기회를 얻는다.
    // 이 단게에서 사용자는 자신의 카드를 보고, 딜러의 두 카드 중 하나를 본다.
    // 카지노에서는 딜러가 한 장을 앞면으로 돌리고 다른 한 장은 뒷면으로 둔 채로 보여준다.

    // 사용자는 Hit or Stand를 할지 말지 정할 수 있다 
    // Hit : 또 다른 카드를 손에 추가
    // Stand : 카드 받기를 중단

    // 사용자가 Hit 하면 사용자는 21 초과될 가능성이 있다.
    //       이런 경우 게임이 끝나고 사용자가 패배한다.
    // 그렇지 않은 경우 사용자가 Hit 또는 Stand 여부를 다시 결정하게 된다. (프로세스 계속되는 것)

    // 사용자가 Stand 하면 게임이 종료되지만, 먼저 딜러가 카드를 뽑을 기회를 얻는다.
    // 딜러는 선택의 여지 없이 규칙만을 뜨른다.
    // 규칙은 딜러의 패값이 16 이하인 한, 딜러는 Hit (다른 카드를 가져옴) 한다는 것
    // 이 시점에서 사용자는 딜러의 모든 카드를 볼 수 있다.
    
    // 이제 승자를 결정할 수 있다!
    // 딜러가 21을 초과하면 사용자가 승리!
    // 아니라면, 딜러의 패값이 사용자의 패값 이상이라면, 딜러가 승리!
    // 아니라면, 사용자가 승리!

    // 참고 사항
    // 1. 메서드의 어느 시점에서든, 승자가 누구인지 알게 되자마자, 
    // return true or return false 해서 메서드를 종료하고 메인 프로그램에 리턴해줄 수 있어야 한다.
    // 메서드에 변수가 너무 많아지는 것을 방지하기 위하여, 
    // userHand.getBlackjackValue() 와 같은, function call 을 활용하자.
    // functions call 을 출력 문에 포함시키거나, if 문의 조건에 포함시킬 수 있다.

    // 사용자가 여러 블랙잭 게임을 플레이할 수 있는 메인 프로그램을 만들자.
    // 게임을 재미있게 만들기 위해, 사용자에게 100달러를 주고,
    // 사용자가 게임에서 베팅하게 만들자.
    // 만약 사용자가 패배하면, 사용자의 돈에서 베팅 값을 빼주자.
    // 만약 사용자가 승리하면, 사용자의 돈에 베팅값을 더해주자.
    // 사용자가 게임을 끝내기를 원하거나, 주어진 돈을 다 탕진하면 
    // 프로그램을 끝내자.


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BlackjackGame blackjackGame = new BlackjackGame();
        boolean isUserWin = blackjackGame.playGameByUser(sc);
        blackjackGame.printGameResult(isUserWin);
        sc.close();
    }

    






    
}