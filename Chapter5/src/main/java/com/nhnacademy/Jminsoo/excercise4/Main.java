package com.nhnacademy.Jminsoo.excercise4;

import com.nhnacademy.Jminsoo.textio.TextIO;

public class Main {
    public static void main(String[] args) {

        int gamesPlayed = 0;
        int sumOfScores = 0;

        double averageScore;
        boolean playAgain;

        do {
            boolean isVictory;        // Score for one game.
            isVictory = play();   // Play the game and get the score.
            if (isVictory) {
                sumOfScores++;
            }
            gamesPlayed++;
            System.out.print("다시 플레이하겠습니까?(다시하기 : true, 그만두기 : false) : ");
            playAgain = TextIO.getlnBoolean();
        } while (playAgain);

        averageScore = ((double) sumOfScores) / gamesPlayed;

        System.out.println();
        System.out.println("게임 횟수 :  " + gamesPlayed + " games.");
        System.out.printf("평균 승다 : %1.3f.\n", averageScore);
    }

    private static boolean play() {
        final int blackJackMaxNum = 21;
        BlackjackHand hand = new BlackjackHand();
        Deck deck = new Deck();
        Card card;
        char answer;
        int initGetCard;

        deck.shuffle();
        System.out.print("받고 싶은 카드의 개수를 입력 하세요 (2 ~ 6) : ");

        initGetCard = TextIO.getlnInt();
        for (int i = 1; i <= initGetCard; i++) {
            card = deck.dealCard();
            hand.addCard(card);
        }

        while (true) {

            showHand(hand);
            if (hand.getBlackjackValue() > blackJackMaxNum) {
                System.out.printf("받은 카드가 %d보다 큽니다. 패배합니다.\n", blackJackMaxNum);
                return false;
            } else if (hand.getBlackjackValue() == blackJackMaxNum) {
                System.out.printf("%d와 값이 맞습니다! 승립합니다!", blackJackMaxNum);
                return true;
            }

            do {
                answer = heatOrStand();

            } while (answer != 'Y' && answer != 'N');

            if (answer == 'N') {
                break;
            }

            card = deck.dealCard();
            System.out.println("다음 카드 : " + card);
            hand.addCard(card);

        }

        System.out.println();
        System.out.println("게임 종료");

        return false;
    }

    private static void checkVictory() {

    }

    private static void showHand(BlackjackHand hand) {
        for (int i = 0; i < hand.getCardCount(); i++) {
            System.out.printf("손 패 : %s\n", hand.getCard(i));
        }
        System.out.printf("현재 카드의 값의 합계 : %d\n", hand.getBlackjackValue());
        System.out.printf("현재 카드 장수 : %d\n", hand.getCardCount());
    }

    private static char heatOrStand() {
        char answer;
        System.out.print("새 카드를 받으시겠습니까? (Y / N) : ");
        answer = TextIO.getlnChar();
        answer = Character.toUpperCase(answer);
        if (answer != 'Y' && answer != 'N') {
            System.out.print("Y 또는 N으로 입력해주시길 바랍니다 : ");
            return ' ';
        } else {
            return answer;
        }
    }
}
