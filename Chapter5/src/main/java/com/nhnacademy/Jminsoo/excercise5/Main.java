package com.nhnacademy.Jminsoo.excercise5;

import com.nhnacademy.Jminsoo.textio.TextIO;

public class Main {
    public static void main(String[] args) {

        int gamesPlayed = 0;
        int sumOfScores = 0;

        int money = 100;
        int bet = 0;


        double averageScore;
        boolean playAgain = false;
        Player player;
        Dealer dealer;

        do {
            System.out.printf("현재 돈 : %d\n", money);
            if (money <= 0) {
                System.out.println("돈이 없습니다!");
                break;
            }
            player = new Player("Player", new BlackjackHand());
            dealer = new Dealer("Dealer", new BlackjackHand());
            boolean isVictory;        // Score for one game.

            //돈 걸기
            System.out.println("베팅 금액을 설정해주세요");
            bet = TextIO.getlnInt();
            if (bet > money) {
                System.out.printf("베팅 금액은 현재 금액보다 많을 수 없습니다. 현재 돈 : %d\n", money);
                continue;
            }

            isVictory = play(player, dealer);   // Play the game and get the score.
            if (isVictory) {
                System.out.printf("베팅 금액을 받습니다. %d\n", bet);
                money += bet;
                sumOfScores++;
            } else {
                System.out.printf("베팅 금액을 잃습니다. -%d\n", bet);
                money -= bet;
            }
            gamesPlayed++;
            System.out.print("다시 플레이하겠습니까?(다시하기 : true, 그만두기 : false) : ");
            playAgain = TextIO.getlnBoolean();
        } while (playAgain);

        averageScore = ((double) sumOfScores) / gamesPlayed;

        System.out.println();
        System.out.println("게임 횟수 :  " + gamesPlayed + " games.");
        System.out.printf("평균 승률 : %1.3f.\n", averageScore * 100);
    }

    //손패 출력
    private static void printHand(Player player) {
        System.out.println();
        System.out.printf("%s의 현재 패\n", player.getName());
        System.out.println("===============");
        for (int i = 0; i < player.getHand().getCardCount(); i++) {
            System.out.println(player.getHand().getCard(i));
        }
        System.out.println("===============");
        System.out.println();

        System.out.printf("현재 카드의 값의 합계 : %d\n", player.getHandValue());
        System.out.printf("현재 카드 장수 : %d\n", player.getHand().getCardCount());
        System.out.println();

    }

    private static boolean checkVictory(Player player, Dealer dealer) {
        printHand(player);
        printHand(dealer);

        //둘 다 21일 경우
        if (player.getHandValue() == 21 && dealer.getHandValue() == 21) {
            return false;
        } else if (dealer.getHandValue() == 21) {
            //딜러만 21일 경우
            return false;
        } else if (player.getHandValue() == 21) {
            //플레이어만 21일경우
            return true;
        } else {
            return player.getHand().getBlackjackValue() > dealer.getHand().getBlackjackValue();
        }
    }

    private static boolean play(Player player, Dealer dealer) {
        final int initCard = 2;
        Deck deck = new Deck();
        Card card;
        String answer;

        deck.shuffle();

        for (int i = 0; i < initCard; i++) {
            player.getHand().addCard(deck.dealCard());
            dealer.getHand().addCard(deck.dealCard());
        }

        //둘 다 21일 경우
        if (player.getHandValue() == 21 && dealer.getHandValue() == 21) {
            return false;
        } else if (dealer.getHandValue() == 21) {
            //딜러만 21일 경우
            return false;
        } else if (player.getHandValue() == 21) {
            //플레이어만 21일경우
            return true;
        }


        while (true) {
            printHand(player);

            System.out.println("딜러의 패");
            System.out.println("===============");
            System.out.println(dealer.getHand().getCard(0));
            System.out.println("===============");
            System.out.println();

            if (player.getHandValue() > 21) {
                System.out.println("패배했습니다!");
                return false;
            } else {
                do {
                    System.out.print("새 카드를 받으시겠습니까? (Stand / Heat) : ");
                    answer = TextIO.getln();

                    if (answer.equals("Stand") || answer.equals("Heat")) {
                        break;
                    } else {
                        System.out.println("Stand 또는 Heat 입력해주시길 바랍니다");
                    }
                } while (!answer.equals("Stand") && !answer.equals("Heat"));

                if (answer.equals("Stand")) {
                    if (dealer.getHandValue() < 16) {
                        System.out.println("딜러의 패가 16보다 작으므로 패를 한장 받습니다.");
                        card = deck.dealCard();
                        dealer.getHand().addCard(card);
                    }

                    boolean victory = checkVictory(player, dealer);
                    if (victory) {
                        System.out.println("플레이어 우승!");
                    } else {
                        System.out.println("플레이어 패배!");
                    }
                    return victory;

                } else if (answer.equals("Heat")) {
                    card = deck.dealCard();
                    System.out.println("\n\n다음 카드 : " + card);
                    player.getHand().addCard(card);

                }
            }
        }
    }
}
