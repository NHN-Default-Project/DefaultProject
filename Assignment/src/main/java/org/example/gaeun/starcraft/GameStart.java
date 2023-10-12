package org.example.gaeun.starcraft;


public class GameStart {

    private static boolean isFinished = false;
    public static void setFinished() {
        isFinished = true;
    }

    public static void gameStart() {
        Starcraft starcraft = new Starcraft();
        User user = new User();
        Computer computer = new Computer();

        User.userChoiceUnit(); //사용자 유닛 선택
        Computer.comChoiceUnit(); //컴퓨터 유닛 선택

        starcraft.printStatus(); //선택된 유닛 출력

        while(!isFinished) { //게임시작
            user.attackUser();
            if(isFinished) {
                break;
            }
            starcraft.printStatus();
            computer.attackComputer();
            if(isFinished) {
                break;
            }
            starcraft.printStatus();
        }

    }
    public static void main(String[] args) {
        gameStart();
    }
}
